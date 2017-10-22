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
import com.zzkj.xyw.util.ControllerUtil;

@Controller
public class NoticeControlller {

	@Autowired
	private INoticeService noticeService;
	
	// 管理界面公告一览
	@RequestMapping("/manage/notice")
	public String noticeList(Model model){
		
		int pageNow = 0;
		int pageSize = 2;
		int cnt = 0;
		List<Notice> noticeList = null;
		
		noticeList = noticeService.findByPage(pageNow, pageSize);
		cnt = noticeService.noticeCnt();
		ControllerUtil.addParam(model, pageSize, pageNow, noticeList, "noticeList", cnt);
		
		return "/manage/notice";
	}
	
	@RequestMapping(value = "/manage/notice/{pageNow}")
	public String noticeList(@PathVariable int pageNow, Model model) {
		
		int pageSize = 2;
		int cnt = 0;
		List<Notice> noticeList = null;
		
		noticeList = noticeService.findByPage(pageNow, pageSize);
		cnt = noticeService.noticeCnt();
		ControllerUtil.addParam(model, pageSize, pageNow, noticeList, "noticeList", cnt);
		
		return "/manage/notice";
	}
	
	// 添加公告
	@RequestMapping(value = "/manage/notice/add")
	public String addNotice(Notice notice, Model model, HttpSession session) {
		
		try {
			noticeService.create(notice);
			model.addAttribute("msg", "发布公告成功！");
		} catch (Exception e) {
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
			model.addAttribute("msg", "删除公告失败！");
		}
		
		return noticeList(model);
	}

	// 返回添加公告view
	@RequestMapping(value = "/manage/addNotice")
	public String addNotice() {
	
		return "/manage/addNotice";
	}
}
