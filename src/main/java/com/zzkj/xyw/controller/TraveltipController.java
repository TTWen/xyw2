package com.zzkj.xyw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zzkj.xyw.model.Remark;
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
	public String traveltipManage(Integer pageNow, Model model) {

		int pageSize = 2;
		int cnt = 0;
		if (pageNow == null) {
			pageNow = 0;
		}
		List<Traveltip> traveltipList = null;

		traveltipList = traveltipService.findByPage(pageNow, pageSize);
		cnt = traveltipService.ttCnt();

		ControllerUtil.addParam(model, pageSize, pageNow, traveltipList,
				"traveltipList", cnt);
		return "/manage/traveltip";
	}

	@RequestMapping(value = "/manage/traveltip/{pageNow}")
	public String traveltipManage2(@PathVariable int pageNow, Model model) {

		return traveltipManage(pageNow, model);
	}

	// 管理员删除攻略
	@RequestMapping(value = "/manage/deleteTraveltip")
	public String deleteTraveltip(String[] ttid, Model model) {

		traveltipService.delete(ttid);
		return traveltipManage(0, model);
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
		if (file != null) {
			String ttpic = UploadFile.doUpload("F:/xyw/traveltippic/", file,
					traveltip.getTtid());
			traveltip.setTtpic(ttpic.substring(6));
			traveltipService.update(traveltip);
		}
		return "/success";
	}

	// 用户删除攻略
	@RequestMapping(value = "/traveltip/delete/{ttid}")
	public String deleteTraveltip(@PathVariable int ttid, Model model,
			HttpSession session) throws Exception {

		traveltipService.delete(new String[] { String.valueOf(ttid) });

		return "/success";
	}

	// 攻略一览
	@RequestMapping("/user/traveltip")
	public String traveltipList(@PathVariable Integer pageNow, Model model,
			HttpSession session) {

		int pageSize = 2;
		int cnt = 0;
		if (pageNow == null) {
			pageNow = 0;
		}
		List<Traveltip> traveltipList = null;
		List<TraveltipOp> ttopList = null;
		int crtuid = (Integer) session.getAttribute("crtuid");

		traveltipList = traveltipService.findByPage(pageNow, pageSize);

		// 当前页攻略id组成的list
		List<Integer> ttids = new ArrayList<Integer>();
		for (Traveltip tt : traveltipList) {
			ttids.add(tt.getTtid());
		}
		// 用户对当前页攻略的操作记录list
		ttopList = ttLikeService.findAll(ttids, crtuid);
		// 按当前页顺序设置ttop中的traveltip属性
		int i = 0;
		for (Traveltip tt : traveltipList) {
			ttopList.get(i).setTt(tt);
			i++;
		}

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
	@RequestMapping(value = "/search")
	public String traveltipList3(@PathVariable Integer pageNow, Model model,
			HttpSession session) {

		return traveltipList(pageNow, model, session);
	}

	@RequestMapping(value = "/search")
	public String traveltipSearch(@PathVariable Integer pageNow, String keyword,
			Model model, HttpSession session) {

		return traveltipList(pageNow, model, session);
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
		int crtuid = (Integer) session.getAttribute("crtuid");

		ttcltList = ttCltService.findByPage(pageNow, pageSize, crtuid);

		// 当前页的攻略id组成的list
		List<Integer> ttids = new ArrayList<Integer>();
		for (TtClt tt : ttcltList) {
			ttids.add(tt.getCttid());
		}
		List<TraveltipOp> ttopList = ttLikeService.findAll(ttids, crtuid);

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

		List<Integer> ttids = new ArrayList<Integer>();
		ttids.add(ttid);

		List<TraveltipOp> ttopList = ttLikeService.findAll(ttids, crtuid);
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

}
