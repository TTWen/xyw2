package com.zzkj.xyw.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzkj.xyw.model.Feedback;
import com.zzkj.xyw.service.IFeedbackService;
import com.zzkj.xyw.util.ControllerUtil;

@Controller
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;
	
	// 反馈页面
	@RequestMapping("/user/feedback")
	public String feedback(){
		
		return "/feedback";
	}
	
	// 提交反馈
	@RequestMapping("/user/addFeedback")
	public String addFeedback(Feedback fb, Model model){
		
		feedbackService.create(fb);
		model.addAttribute("msg", "反馈成功！");
		return "/feedback";
	}
	
	/*
	 * 管理员反馈管理
	 */
	
	// 显示所有反馈
	@RequestMapping("/manage/feedback")
	public String setFbState(Integer fstate, HttpSession session, Model model){
		
		if(fstate == null){
			fstate = 2;
		}
		session.setAttribute("fstate", fstate);
		
		return feedback(fstate, 0, model);
	}
	
	public String feedback(Integer fstate, Integer pageNow, Model model){
		
		int pageSize = 2;
		int cnt = 0;
		if(pageNow == null) {
			pageNow = 0;
		}
		Criterion c = Restrictions.ge("fid", 1);
		if(fstate == 0) {
			c = Restrictions.eq("fstate", 0);
		}
		cnt = feedbackService.cnt(c);
		if(cnt == 0) {
			model.addAttribute("msg", "无反馈信息！");
		}
		List<Feedback> fbList = feedbackService.findByPage(pageNow, pageSize, c);
		ControllerUtil.addParam(model, pageSize, pageNow, fbList, "fbList", cnt);
		return "/manage/feedback";
	}
	
	@RequestMapping("/manage/feedback/{pageNow}")
	public String feedback2(@PathVariable Integer pageNow, Model model,
			HttpSession session){
		
		Integer fstate = (Integer) session.getAttribute("fstate");
		return feedback(fstate, pageNow, model);
	}
	
	@RequestMapping("/manage/feedbackDetail/{fid}")
	public String feedbackDetail(@PathVariable int fid, Model model) {
		
		Feedback fb = feedbackService.findById(fid);
		fb.setFstate(1);
		feedbackService.update(fb);
		model.addAttribute("fb", fb);
		return "/manage/feedbackDetail";
	}
	
}
