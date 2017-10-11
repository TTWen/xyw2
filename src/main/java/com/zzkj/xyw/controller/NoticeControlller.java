package com.zzkj.xyw.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.ehcache.search.parser.MCriteria.Simple;

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
	
	public void addParam(Model model, int pageSize, int pageNow,
			List<Notice> noticeList){
		int allPages = (noticeService.noticeCnt() -1)/pageSize + 1;
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageNow", pageNow);
		model.addAttribute("allPages", allPages);
	}
	
	// 管理界面公告一览
	@RequestMapping("/manage/notice")
	public String noticeList(Model model){
		int pageSize = 2;
		List<Notice> noticeList = noticeService.findByPage(0, pageSize);
		addParam(model, pageSize, 0, noticeList);
		return "/manage/notice";
	}
	
	@RequestMapping(value = "/manage/notice/{pageNow}")
	public String noticeList(@PathVariable int pageNow, Model model) {
		int pageSize = 2;
		List<Notice> noticeList = noticeService.findByPage(pageNow, pageSize);
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
		//int mid = (Integer) session.getAttribute("crtmid");
		int mid = 1;
		notice.setNmid(mid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		notice.setNtime(sdf.format(date));
		noticeService.create(notice);
		model.addAttribute("msg", "发布公告成功");
		return noticeList(model);
	}
	
	// 删除公告
	@RequestMapping(value = "/manage/deleteNotice")
	public String deleteSort(String[] nid, Model model) {

		noticeService.delete(nid);
		model.addAttribute("msg", "删除公告成功");
		return noticeList(model);
	}
}
