package com.zzkj.xyw.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzkj.xyw.model.Traveltip;
import com.zzkj.xyw.model.TtClt;
import com.zzkj.xyw.model.TtLike;
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
	public String traveltipList2(Model model){
		
		int pageSize = 2;
		List<Traveltip> traveltipList = null;
		try {
			traveltipList = traveltipService.findByPage(0, pageSize);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		addParam(model, pageSize, 0, traveltipList);
		
		return "/traveltip";
	}
	
	@RequestMapping(value = "/user/traveltip/{pageNow}")
	public String traveltipList2(@PathVariable int pageNow, Model model) {
		int pageSize = 2;
		List<Traveltip> traveltipList = null;
		try {
			traveltipList = traveltipService.findByPage(pageNow, pageSize);
		} catch (Exception e) {
			// TODO: handle exception
		}
		addParam(model, pageSize, pageNow, traveltipList);
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

		
		ttLikeService.delete(new String[]{String.valueOf(ttid)});
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

		ttCltService.delete(new String[]{String.valueOf(ttid)});

		return "/success";
	}
}
