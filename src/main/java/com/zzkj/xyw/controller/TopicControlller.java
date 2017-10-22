package com.zzkj.xyw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzkj.xyw.model.Remark;
import com.zzkj.xyw.model.Topic;
import com.zzkj.xyw.service.IRemarkService;
import com.zzkj.xyw.service.ITopicService;

@Controller
public class TopicControlller {

	@Autowired
	private ITopicService topicService;
	@Autowired
	private IRemarkService remarkService;
	
	// 添加评论
	@RequestMapping(value = "/user/addTopic")
	public String addTopic(Topic topic, Model model, HttpSession session) {
		
		
		try {
			topicService.create(topic);
			model.addAttribute("msg", "发布评论成功！");
		} catch (Exception e) {
			model.addAttribute("msg", "发布评论失败！");
		}
		return "/success";
	}
	
	
	// 添加回复
	@RequestMapping(value = "/user/addRemark")
	public String addRemark(Remark remark, Model model, HttpSession session) {
		
		try {
			remarkService.create(remark);
			model.addAttribute("msg", "回复成功！");
		} catch (Exception e) {
			model.addAttribute("msg", "回复失败！");
		}
		return "/success";
	}
	
	// 删除评论
	@RequestMapping(value = "/user/deleteTopic/{tpid}")
	public String deleteTopic(@PathVariable int tpid, Model model) {

		topicService.delete(new String[]{String.valueOf(tpid)});
//		try {
//			topicService.delete(tpid);
//			model.addAttribute("msg", "删除评论成功！");
//		} catch (Exception e) {
//			model.addAttribute("msg", "删除评论失败！");
//		}
		
		return "/success";
	}
	
	// 删除回复
	@RequestMapping(value = "/user/deleteRemark/{rid}")
	public String deleteRemark(@PathVariable int rid, Model model) {

		remarkService.delete(new String[]{String.valueOf(rid)});
//		try {
//			remarkService.delete(rid);
//			model.addAttribute("msg", "删除回复成功！");
//		} catch (Exception e) {
//			// TODO: handle exception
//			model.addAttribute("msg", "删除回复失败！");
//		}
		return "/success";
	}
}
