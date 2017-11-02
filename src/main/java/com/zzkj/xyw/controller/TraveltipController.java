package com.zzkj.xyw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zzkj.xyw.model.Remark;
import com.zzkj.xyw.model.Search;
import com.zzkj.xyw.model.Topic;
import com.zzkj.xyw.model.Traveltip;
import com.zzkj.xyw.model.TraveltipDetail;
import com.zzkj.xyw.model.TraveltipOp;
import com.zzkj.xyw.model.TtClt;
import com.zzkj.xyw.model.TtLike;
import com.zzkj.xyw.service.IRemarkService;
import com.zzkj.xyw.service.ITopicService;
import com.zzkj.xyw.service.ITraveltipService;
import com.zzkj.xyw.service.ITtCltService;
import com.zzkj.xyw.service.ITtLikeService;
import com.zzkj.xyw.util.ControllerUtil;
import com.zzkj.xyw.util.UploadFile;

@Controller
public class TraveltipController {

	@Autowired
	private ITraveltipService traveltipService;
	@Autowired
	private ITtCltService ttCltService;
	@Autowired
	private ITtLikeService ttLikeService;
	@Autowired
	private ITopicService topicService;
	@Autowired
	private IRemarkService remarkService;

	// 管理界面攻略一览
	@RequestMapping("/manage/traveltip")
	public String setIsCheck(Model model, Integer isCheck, HttpSession session) {

		if (isCheck == null) {
			isCheck = 0;
		}
		session.setAttribute("isCheck", isCheck);
		return traveltipManage(0, model, session);
	}

	public String traveltipManage(Integer pageNow, Model model,
			HttpSession session) {

		Integer isCheck = (Integer) session.getAttribute("isCheck");
		int pageSize = 2;
		int cnt = 0;
		if (pageNow == null) {
			pageNow = 0;
		}
		List<Traveltip> traveltipList = null;

		Criterion c = null;
		// ischeck为1表示显示所有攻略
		if (isCheck == 1) {
			c = Restrictions.ge("ttid", 1);
			// ischeck为0表示显示未审核攻略
		} else {
			c = Restrictions.eq("ttischeck", 0);
		}
		traveltipList = traveltipService.findByPage(pageNow, pageSize, c);
		cnt = traveltipService.cnt(c);
		ControllerUtil.addParam(model, pageSize, pageNow, traveltipList,
				"traveltipList", cnt);

		return "/manage/traveltip";
	}

	@RequestMapping(value = "/manage/traveltip/{pageNow}")
	public String traveltipManage2(@PathVariable int pageNow, Model model,
			HttpSession session) {

		return traveltipManage(pageNow, model, session);
	}

	// 管理员删除攻略
	@RequestMapping(value = "/manage/deleteTraveltip")
	public String deleteTraveltip(String[] ttid, Model model,
			HttpSession session) {

		traveltipService.delete(ttid);
		return traveltipManage(0, model, session);
	}

	// 管理员审核
	@RequestMapping(value = "/manage/checktt/{ttid}")
	public String checktt(@PathVariable int ttid, Model model) {

		Traveltip tt = traveltipService.findById(ttid);
		model.addAttribute("tt", tt);
		return "/manage/checktt";
	}

	// 审核通过
	@RequestMapping(value = "/manage/checkPass/{ttid}")
	public String checkPass(@PathVariable int ttid, Model model) {

		Traveltip tt = traveltipService.findById(ttid);
		tt.setTtischeck(1);
		traveltipService.update(tt);
		model.addAttribute("tt", tt);
		return "/success";
	}

	// 审核未通过，删除
	@RequestMapping(value = "/manage/checkUnpass/{ttid}")
	public String checkUnpass(@PathVariable int ttid, Model model) {

		traveltipService.delete(new String[] { String.valueOf(ttid) });

		return "/success";
	}

	/*
	 * 用户有关攻略操作
	 */

	// 用户添加攻略
	@RequestMapping(value = "/traveltip/add")
	public String addTraveltip(Traveltip traveltip, MultipartFile file,
			Model model, HttpSession session) throws Exception {

		traveltipService.create(traveltip);

		// 攻略封面图上传
		if (!file.isEmpty()) {
			String ttpic = UploadFile.doUpload("F:/xyw/traveltippic/", file,
					traveltip.getTtid());
			traveltip.setTtpic(ttpic.substring(6));
			traveltipService.update(traveltip);
		}
		return "/success";
	}

	// 用户修改攻略页面
	@RequestMapping(value = "/modifyTraveltip/{ttid}")
	public String modifyTraveltip(@PathVariable int ttid, Model model,
			HttpSession session) throws Exception {

		Integer crtuid = (Integer) session.getAttribute("crtuid");
		Traveltip tt = traveltipService.findById(ttid);
		if (tt.getTtuid() != crtuid) {
			return "/error";
		}
		model.addAttribute("tt", tt);
		return "/modifyTraveltip";
	}

	// 修改攻略
	@RequestMapping(value = "/traveltip/modify")
	public String modifyTraveltip(Traveltip tt, Model model,
			MultipartFile file, HttpSession session) throws Exception {
		Integer crtuid = (Integer) session.getAttribute("crtuid");
		if (tt.getTtuid() != crtuid) {
			return "/error";
		}
		if (!file.isEmpty()) {
			String ttpic = UploadFile.doUpload("F:/xyw/traveltippic/", file,
					tt.getTtid());
			tt.setTtpic(ttpic.substring(6));
		} else {
			// 标志用户未修改封面图
			tt.setTtpic("0");
		}
		traveltipService.update(tt);
		return "/success";
	}

	// 用户删除攻略
	@RequestMapping(value = "/traveltip/delete/{ttid}")
	public String deleteTraveltip(@PathVariable int ttid, Model model,
			HttpSession session) throws Exception {

		Integer crtuid = (Integer) session.getAttribute("crtuid");
		Traveltip tt = traveltipService.findById(ttid);
		if (tt.getTtuid() != crtuid) {
			return "/error";
		}
		traveltipService.delete(new String[] { String.valueOf(ttid) });
		return "/success";
	}

	// 攻略库
	@RequestMapping("/user/traveltip")
	public String traveltipList(Integer pageNow, Model model,
			HttpSession session) {

		int pageSize = 2;
		int cnt = 0;
		if (pageNow == null) {
			pageNow = 0;
		}
		List<Traveltip> traveltipList = null;
		List<TraveltipOp> ttopList = null;
		Integer crtuid = (Integer) session.getAttribute("crtuid");

		traveltipList = traveltipService.findByPage(pageNow, pageSize);

		// 用户对当前页攻略的操作记录list
		ttopList = ttLikeService.findAll(traveltipList, crtuid);

		cnt = traveltipService.ttCnt();
		ControllerUtil.addParam(model, pageSize, pageNow, ttopList, "ttopList",
				cnt);

		return "/traveltip";
	}

	@RequestMapping(value = "/user/traveltip/{pageNow}")
	public String traveltipList2(@PathVariable Integer pageNow, Model model,
			HttpSession session) {

		return traveltipList(pageNow, model, session);
	}

	// 关键字查找攻略
	// 先在session中设置查询条件
	@RequestMapping(value = "/search")
	public String setSearch(Search sc, Model model, HttpSession session) {

		session.setAttribute("search", sc);
		return traveltipSearch(0, model, session);
	}

	public String traveltipSearch(Integer pageNow, Model model,
			HttpSession session) {

		int pageSize = 2;
		int cnt = 0;
		Integer crtuid = (Integer) session.getAttribute("crtuid");

		List<TraveltipOp> ttopList = new ArrayList<TraveltipOp>();
		List<Traveltip> traveltipList = new ArrayList<Traveltip>();
		cnt = traveltipService.cnt(pageNow, pageSize, traveltipList, session);

		// 没有找到符合条件的数据
		if (cnt == 0) {
			model.addAttribute("msg", "未找到符合条件的攻略！");
			return "/search";
		}
		ttopList = ttLikeService.findAll(traveltipList, crtuid);

		ControllerUtil.addParam(model, pageSize, pageNow, ttopList, "ttopList",
				cnt);
		return "/search";
	}

	// 查询攻略关键字keyword的传递
	@RequestMapping(value = "/search/{pageNow}")
	public String traveltipSearch2(@PathVariable Integer pageNow, Model model,
			HttpSession session) {

		return traveltipSearch(pageNow, model, session);
	}

	// 点赞
	@RequestMapping(value = "/user/likeTraveltip/{ttid}")
	public String likeTraveltip(@PathVariable int ttid, Model model,
			HttpSession session) {

		TtLike like = new TtLike();
		int luid = (Integer) session.getAttribute("crtuid");

		like.setLttid(ttid);
		like.setLuid(luid);

		ttLikeService.create(like);

		// 攻略点赞数增加
		Traveltip tt = traveltipService.findById(ttid);
		tt.setTtlike(tt.getTtlike() + 1);
		traveltipService.update(tt);

		return "/success";
	}

	// 取消点赞
	@RequestMapping(value = "/user/unlikeTraveltip/{ttid}")
	public String unlikeTraveltip(@PathVariable int ttid, Model model,
			HttpSession session) {

		int luid = (Integer) session.getAttribute("crtuid");

		ttLikeService.delete("luid=" + luid + " and lttid=" + ttid);

		Traveltip tt = traveltipService.findById(ttid);
		tt.setTtlike(tt.getTtlike() - 1);
		traveltipService.update(tt);

		return "/success";
	}

	// 收藏
	@RequestMapping(value = "/user/cltTraveltip/{ttid}")
	public String cltTraveltip(@PathVariable int ttid, Model model,
			HttpSession session) {

		TtClt clt = new TtClt();
		int cuid = (Integer) session.getAttribute("crtuid");

		clt.setCttid(ttid);
		clt.setCuid(cuid);

		ttCltService.create(clt);

		return "/success";
	}

	// 取消收藏
	@RequestMapping(value = "/user/uncltTraveltip/{ttid}")
	public String uncltTraveltip(@PathVariable int ttid, Model model,
			HttpSession session) {

		int cuid = (Integer) session.getAttribute("crtuid");
		ttCltService.delete("cuid=" + cuid + " and cttid=" + ttid);

		return "/success";
	}

	// 个人收藏
	@RequestMapping("/user/ttclt")
	public String ttclt(Integer pageNow, Model model, HttpSession session) {

		int pageSize = 2;
		if (pageNow == null) {
			pageNow = 0;
		}
		int cnt = 0;
		List<TtClt> ttcltList = null;
		List<Traveltip> traveltipList = new ArrayList<Traveltip>();
		int crtuid = (Integer) session.getAttribute("crtuid");

		ttcltList = ttCltService.findByPage(pageNow, pageSize, crtuid);
		for (TtClt ttClt : ttcltList) {
			traveltipList.add(traveltipService.findById(ttClt.getCttid()));
		}

		List<TraveltipOp> ttopList = ttLikeService.findAll(traveltipList,
				crtuid);
		cnt = ttCltService.cnt(crtuid);

		ControllerUtil.addParam(model, pageSize, pageNow, ttopList, "ttopList",
				cnt);
		return "/ttclt";
	}

	@RequestMapping("/user/ttclt/{pageNow}")
	public String ttclt2(@PathVariable Integer pageNow, Model model,
			HttpSession session) {

		return ttclt2(pageNow, model, session);
	}

	// 攻略详情
	@RequestMapping(value = "/traveltipDetail/{ttid}")
	public String traveltipDetail(@PathVariable int ttid, Integer pageNow,
			Model model, HttpSession session) {

		int crtuid = (Integer) session.getAttribute("crtuid");
		TraveltipOp ttop = new TraveltipOp();
		List<Traveltip> traveltipList = new ArrayList<Traveltip>();
		Traveltip tt = traveltipService.findById(ttid);
		// 点开攻略详情 攻略浏览数加 1
		tt.setTtview(tt.getTtview() + 1);
		traveltipService.update(tt);

		traveltipList.add(tt);
		List<TraveltipOp> ttopList = ttLikeService.findAll(traveltipList,
				crtuid);
		ttop = ttopList.get(0);
		model.addAttribute("ttop", ttop);

		// 显示 评论 及 回复
		if (pageNow == null) {
			pageNow = 0;
		}
		int pageSize = 2;
		int cnt = 0;
		cnt = topicService.topicCnt(ttid);
		List<TraveltipDetail> ttDetailList = new ArrayList<TraveltipDetail>();
		List<Topic> topicList = topicService
				.findByPage(pageNow, pageSize, ttid);

		for (Topic topic : topicList) {
			TraveltipDetail ttd = new TraveltipDetail();

			ttd.setTpc(topic);
			List<Remark> rmkList = remarkService.findAll(topic.getTpid());
			ttd.setRmk(rmkList);

			ttDetailList.add(ttd);
		}
		ControllerUtil.addParam(model, pageSize, pageNow, ttDetailList,
				"ttDetailList", cnt);
		return "/traveltipDetail";
	}

	@RequestMapping(value = "/traveltipDetail/{ttid}/{pageNow}")
	public String traveltipDetail2(@PathVariable int ttid,
			@PathVariable Integer pageNow, Model model, HttpSession session) {

		return traveltipDetail(ttid, pageNow, model, session);
	}

	// 返回添加攻略view
	@RequestMapping(value = "/addTraveltip")
	public String addTraveltip() {

		return "/addTraveltip";
	}

	// 用户主页攻略
	@RequestMapping("/user/selfTraveltip/{ttuid}")
	public String selfTraveltip(@PathVariable int ttuid, Integer pageNow,
			Model model, HttpSession session) {

		int pageSize = 2;
		int cnt = 0;
		if (pageNow == null) {
			pageNow = 0;
		}
		List<Traveltip> traveltipList = null;
		List<TraveltipOp> ttopList = null;
		Integer crtuid = (Integer) session.getAttribute("crtuid");
		Criterion c = Restrictions.eq("ttuid", ttuid);
		traveltipList = traveltipService.findByPage(pageNow, pageSize, c);

		// 用户对当前页攻略的操作记录list
		ttopList = ttLikeService.findAll(traveltipList, crtuid);

		cnt = traveltipService.cnt(c);
		ControllerUtil.addParam(model, pageSize, pageNow, ttopList, "ttopList",
				cnt);

		return "/selfTraveltip";
	}

	@RequestMapping("/user/selfTraveltip/{ttuid}/{pageNow}")
	public String selfTraveltip2(@PathVariable int ttuid,
			@PathVariable Integer pageNow, Model model, HttpSession session) {

		return selfTraveltip(ttuid, pageNow, model, session);
	}
}
