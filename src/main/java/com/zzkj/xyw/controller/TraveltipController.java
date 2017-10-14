package com.zzkj.xyw.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzkj.xyw.model.Traveltip;
import com.zzkj.xyw.service.ITraveltipService;

@Controller
public class TraveltipController {

	@Autowired
	private ITraveltipService traveltipService;
	
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
		public String deleteSort(String[] ttid, Model model) {

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
}
