package com.zzkj.xyw.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zzkj.xyw.model.User;
import com.zzkj.xyw.service.IUserService;
import com.zzkj.xyw.util.UploadFile;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	// index
	@RequestMapping(value = "/index")
	public String index() {
		
		return "index";
	}
	
	// 返回登录 view
	@RequestMapping(value = "/user/login")
	public String login() {
		
		return "login";
	}
	
	// 返回注册 view
	@RequestMapping(value = "/user/register")
	public String regist() {
		
		return "register";
	}
	
	// 返回注销 view
	@RequestMapping(value = "/user/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("crtuid");
		return "redirect:/index";
	}
	
	// 登录
	@RequestMapping(value = "/user/doLogin")
	public String doLogin(String uname, String upsw, Model model, 
			HttpSession session) {
		
		List <User> li = userService.login(uname, upsw);
		if( !li.isEmpty() ) {
			session.setAttribute("crtuid", li.get(0).getUid());
			session.setAttribute("crtuser", li.get(0));
			return "redirect:/index";
		} else {
			
			model.addAttribute("msg", "登录失败！");
			return "/login";
		}
		
	}
	
	// 注册
	@RequestMapping(value = "/user/doRegister")
	public String doRegist(User user, Model model) {
		
		try {
			
			userService.regist(user);
			model.addAttribute("msg", "注册成功！");
			return "login";
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", "注册失败！");
			return "regist";
		}
		
		
	}
	
	// 用户个人信息
	@RequestMapping(value = "/user/info")
	public String modifyInfo(Model model, HttpSession session) {
		
		int uid = Integer.valueOf((String) session.getAttribute("crtuid"));
		User user = userService.findById(uid);
		model.addAttribute("user", user);
		return "info";
	}
	
	// 修改个人信息
	@RequestMapping(value = "/user/modify")
	public String modifyInfo(User user, Model model, HttpSession session) throws Exception {
		
		int uid = Integer.valueOf((String) session.getAttribute("crtuid"));
		User u2 = userService.findById(uid);
		user.setUpsw(u2.getUpsw());
		user.setUid(uid);
		user.setUurl(u2.getUurl());
		
		userService.update(user);
		model.addAttribute("msg", "修改个人信息成功！");
		return "/index";
	}
	
	// 修改头像
	@RequestMapping(value = "/user/modifyIcon")
	public String modifyIcon(MultipartFile file, Model model, HttpSession session) throws Exception {
		
		int uid = Integer.parseInt(session.getAttribute("crtuid").toString());
		User user = userService.findById(uid);
		String path = UploadFile.doUpload("E:/ebook/icon/", file, uid);
		user.setUurl(path);
		
		userService.update(user);
		model.addAttribute("msg", "修改头像成功！");
		return "/index";
	}
	
	// 管理用户页面
	@RequestMapping(value = "/manage/user")
	public String mgUser(Model model) {
		
		List<User> userList = userService.findByPage(0, 10);
		int allPages = userService.userCnt();
		model.addAttribute("userList", userList);
		model.addAttribute("allPages", allPages);
		return "/manage/user";
	}
	
	// 分页显示用户
	@RequestMapping(value = "/manage/user/{pageNow}")
	public String userList(@PathVariable("pageNow") int pageNow, Model model) {
		
		int pageSize = 10;
		List<User> userList = userService.findByPage(pageNow, pageSize);
		int allPages = userService.userCnt();
		model.addAttribute("userList", userList);
		model.addAttribute("allPages", allPages);
		model.addAttribute("pageNow", pageNow);
		return "/manage/user";
	}
}
