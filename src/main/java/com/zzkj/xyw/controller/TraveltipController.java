package com.zzkj.xyw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	public void addParam(Model model, int pageSize, int pageNow,
			List list, String listName, int cnt) {
		int allPages = 0;
		if(cnt != 0) {
			allPages = (cnt -1)/pageSize + 1;
		} else {
			pageNow = -1;
		}
		
		model.addAttribute(listName, list);
		model.addAttribute("pageNow", pageNow);
		model.addAttribute("allPages", allPages);
	}
	
	// 分页添加model中的属性
	public void addParam(Model model, int pageSize, int pageNow,
			List<Traveltip> traveltipList){
		
		int traveltipCnt = 0;
		int allPages = 0;
		// 攻略数
		try {
			traveltipCnt = traveltipService.ttCnt();
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		// 攻略数为0设置当前页为-1
		if(traveltipCnt != 0) {
			allPages = (traveltipCnt -1)/pageSize + 1;
		} else {
			pageNow = -1;
		}
		
		model.addAttribute("traveltipList", traveltipList);
		model.addAttribute("pageNow", pageNow);
		model.addAttribute("allPages", allPages);
	}
	
	// 管理界面攻略一览
	@RequestMapping("/manage/traveltip")
	public String traveltipList(Model model){
		
		int pageSize = 2;
		List<Traveltip> traveltipList = null;
		try {
			traveltipList = traveltipService.findByPage(0, pageSize);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		addParam(model, pageSize, 0, traveltipList);
		return "/manage/traveltip";
	}
	
	@RequestMapping(value = "/manage/traveltip/{pageNow}")
	public String traveltipList(@PathVariable int pageNow, Model model) {
		int pageSize = 2;
		List<Traveltip> traveltipList = null;
		try {
			traveltipList = traveltipService.findByPage(pageNow, pageSize);
		} catch (Exception e) {
			// TODO: handle exception
		}
		addParam(model, pageSize, pageNow, traveltipList);
		return "/manage/traveltip";
	}
	
	// 返回添加攻略view
	@RequestMapping(value = "/addTraveltip")
	public String addTraveltip() {

		return "/addTraveltip";
	}
	
	// 用户添加攻略
	@RequestMapping(value = "/traveltip/add")
	public String addTraveltip(Traveltip traveltip, Model model, HttpSession session) {
		
		traveltipService.create(traveltip);
		try {
			traveltipService.create(traveltip);
			model.addAttribute("msg", "发布攻略成功！");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", "发布攻略失败！");
		}
		return "/success";
	}
	
	// 删除攻略
	@RequestMapping(value = "/manage/deleteTraveltip")
	public String deleteTraveltip(String[] ttid, Model model) {

//			traveltipService.delete(ttid);
		try {
			traveltipService.delete(ttid);
			model.addAttribute("msg", "删除攻略成功！");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", "删除攻略失败！");
		}
		return traveltipList(model);
	}
	
	///////////////////////
	//用户
	///////////////////////
	
	// 攻略一览
	@RequestMapping("/user/traveltip")
	public String traveltipList2(Model model, HttpSession session){
		int pageSize = 2;
		int pageNow = 0;
		List<Traveltip> traveltipList = null;
		try {
			traveltipList = traveltipService.findByPage(0, pageSize);
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Integer> ttids = new ArrayList<Integer>();
		for (Traveltip tt : traveltipList) {
			ttids.add(tt.getTtid());
		}
		int crtuid = (Integer) session.getAttribute("crtuid");
		List<TraveltipOp> ttopList = ttLikeService.findAll(ttids, crtuid);
		int i = 0;
		for (Traveltip tt : traveltipList) {
			ttopList.get(i).setTt(tt);
			i++;
		}
		int ttCnt = 0;
		ttCnt = traveltipService.ttCnt();
		addParam(model, pageSize, pageNow, ttopList,"ttopList",ttCnt);
		
		return "/traveltip";
	}
	
	@RequestMapping(value = "/user/traveltip/{pageNow}")
	public String traveltipList2(@PathVariable int pageNow, Model model,HttpSession session) {
		int pageSize = 2;
		List<Traveltip> traveltipList = null;
		try {
			traveltipList = traveltipService.findByPage(pageNow, pageSize);
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Integer> ttids = new ArrayList<Integer>();
		for (Traveltip tt : traveltipList) {
			ttids.add(tt.getTtid());
		}
		int crtuid = (Integer) session.getAttribute("crtuid");
		List<TraveltipOp> ttopList = ttLikeService.findAll(ttids, crtuid);
		int i = 0;
		for (Traveltip tt : traveltipList) {
			ttopList.get(i).setTt(tt);
			i++;
		}
		int ttCnt = 0;
		ttCnt = traveltipService.ttCnt();
		addParam(model, pageSize, pageNow, ttopList,"ttopList",ttCnt);
		return "/traveltip";
	}
	
	// 点赞
	@RequestMapping(value = "/user/likeTraveltip/{ttid}")
	public String likeTraveltip(@PathVariable int ttid, Model model, HttpSession session) {

		TtLike like = new TtLike();
		like.setLttid(ttid);
		int luid = (Integer) session.getAttribute("crtuid");
		like.setLuid(luid);
		
		ttLikeService.create(like);
		Traveltip tt = traveltipService.findById(ttid);
		tt.setTtlike(tt.getTtlike()+1);
		traveltipService.update(tt);

		return "/success";
	}
	
	// 取消点赞
	@RequestMapping(value = "/user/unlikeTraveltip/{ttid}")
	public String unlikeTraveltip(@PathVariable int ttid, Model model, HttpSession session) {

		int luid = (Integer) session.getAttribute("crtuid");
		
		ttLikeService.delete("luid="+luid+" and lttid="+ttid);
		
		Traveltip tt = traveltipService.findById(ttid);
		tt.setTtlike(tt.getTtlike()-1);
		traveltipService.update(tt);

		return "/success";
	}
	
	// 收藏
	@RequestMapping(value = "/user/cltTraveltip/{ttid}")
	public String cltTraveltip(@PathVariable int ttid, Model model, HttpSession session) {

		TtClt clt = new TtClt();
		clt.setCttid(ttid);
		int cuid = (Integer) session.getAttribute("crtuid");
		clt.setCuid(cuid);
		
		ttCltService.create(clt);

		return "/success";
	}
	
	// 取消收藏
	@RequestMapping(value = "/user/uncltTraveltip/{ttid}")
	public String uncltTraveltip(@PathVariable int ttid, Model model, HttpSession session) {

		int cuid = (Integer) session.getAttribute("crtuid");
		ttCltService.delete("cuid="+cuid+" and cttid="+ttid);

		return "/success";
	}
	
	// 个人收藏
	@RequestMapping("/user/ttclt")
	public String ttclt(Model model, HttpSession session){
		int pageSize = 2;
		int pageNow = 0;
		List<TtClt> ttcltList = null;
		int crtuid = (Integer) session.getAttribute("crtuid");
		try {
			ttcltList = ttCltService.findByPage(0, pageSize, crtuid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Integer> ttids = new ArrayList<Integer>();
		for (TtClt tt : ttcltList) {
			ttids.add(tt.getCttid());
		}
		List<TraveltipOp> ttopList = ttLikeService.findAll(ttids, crtuid);
		
		int cltCnt = 0;
		cltCnt = ttCltService.cnt(crtuid);
		addParam(model, pageSize, pageNow, ttopList, "ttopList", cltCnt);
		return "/ttclt";
	}
	
	@RequestMapping("/user/ttclt/{pageNow}")
	public String ttclt(@PathVariable int pageNow, Model model, HttpSession session){
		int pageSize = 2;
		List<TtClt> ttcltList = null;
		int crtuid = (Integer) session.getAttribute("crtuid");
		try {
			ttcltList = ttCltService.findByPage(pageNow, pageSize, crtuid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		List<Integer> ttids = new ArrayList<Integer>();
		for (TtClt tt : ttcltList) {
			ttids.add(tt.getCttid());
		}
		List<TraveltipOp> ttopList = ttLikeService.findAll(ttids, crtuid);
		
		int cltCnt = 0;
		cltCnt = ttCltService.cnt(crtuid);
		addParam(model, pageSize, pageNow, ttopList, "ttopList", cltCnt);
		return "/ttclt";
	}
	
	// 攻略详情
	@RequestMapping(value = "/traveltipDetail/{ttid}")
	public String traveltipDetail(@PathVariable int ttid,Model model, HttpSession session) {

		int crtuid = (Integer) session.getAttribute("crtuid");
		TraveltipOp ttop = new TraveltipOp();
		ttop.setTt(traveltipService.findById(ttid));
		List<Integer> ttids = new ArrayList<Integer>();
		ttids.add(ttid);
		List<TraveltipOp> ttopList = ttLikeService.findAll(ttids, crtuid);
		model.addAttribute("ttop", ttopList.get(0));
		
		// 显示 评论 及 回复
		int pageNow = 0;
		int pageSize = 2;
		int cnt = 0;
		cnt = topicService.topicCnt(ttid);
		List<TraveltipDetail> ttDetailli = new ArrayList<TraveltipDetail>();
		List<Topic> tpcli = topicService.findByPage(pageNow, pageSize, ttid);
		for (Topic topic : tpcli) {
			TraveltipDetail ttd = new TraveltipDetail();
			ttd.setTpc(topic);
			ttDetailli.add(ttd);
			List<Remark> rmk = remarkService.findAll(topic.getTpid());
			ttd.setRmk(rmk);
		}
		addParam(model, pageSize, pageNow, ttDetailli, "ttDetailli", cnt);
		return "/traveltipDetail";
	}
	
}
