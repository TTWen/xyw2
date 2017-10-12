package com.zzkj.xyw.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzkj.xyw.model.Notice;
import com.zzkj.xyw.service.INoticeService;

@Controller
public class NoticeControlller {

	@Autowired
	private INoticeService noticeService;
	
	// 分页添加model中的属性
	public void addParam(Model model, int pageSize, int pageNow,
			List<Notice> noticeList){
		
		int noticeCnt = 0;
		int allPages = 0;
		// 公告数
		try {
			noticeCnt = noticeService.noticeCnt();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 公告数为0设置当前页为-1
		if(noticeCnt != 0) {
			allPages = (noticeCnt -1)/pageSize + 1;
		} else {
			pageNow = -1;
		}
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageNow", pageNow);
		model.addAttribute("allPages", allPages);
	}
	
	// 管理界面公告一览
	@RequestMapping("/manage/notice")
	public String noticeList(Model model){
		
		int pageSize = 2;
		List<Notice> noticeList = null;
		try {
			noticeList = noticeService.findByPage(0, pageSize);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		addParam(model, pageSize, 0, noticeList);
		return "/manage/notice";
	}
	
	@RequestMapping(value = "/manage/notice/{pageNow}")
	public String noticeList(@PathVariable int pageNow, Model model) {
		int pageSize = 2;
		List<Notice> noticeList = null;
		try {
			noticeList = noticeService.findByPage(pageNow, pageSize);
		} catch (Exception e) {
			// TODO: handle exception
		}
		addParam(model, pageSize, pageNow, noticeList);
		return "/manage/notice";
	}
	
	// 返回添加公告view
	@RequestMapping(value = "/manage/addNotice")
	public String addNotice() {

		return "/manage/addNotice";
	}
	
	// 添加公告
	@RequestMapping(value = "/manage/notice/add")
	public String addNotice(Notice notice, Model model, HttpSession session) {
		
		try {
			noticeService.create(notice);
			model.addAttribute("msg", "发布公告成功！");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", "发布公告失败！");
		}
		return noticeList(model);
	}
	
	// 删除公告
	@RequestMapping(value = "/manage/deleteNotice")
	public String deleteSort(String[] nid, Model model) {

		try {
			noticeService.delete(nid);
			model.addAttribute("msg", "删除公告成功！");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", "删除公告失败！");
		}
		
		return noticeList(model);
	}
}
