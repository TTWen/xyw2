package com.xt.ebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xt.ebook.model.User;
import com.xt.ebook.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

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
	
	// 登录
	@RequestMapping(value = "/user/doLogin")
	public String doLogin(String uname, String upsw) {
		
		if( userService.login(uname, upsw) != null) {
			
			return "index";
		}
		return "login";
	}
	
	// 注册
	@RequestMapping(value = "/user/doRegister")
	public String doRegist(User user) {
		
		userService.regist(user);
		return "login";
	}
	
	// 用户修改个人信息
	@RequestMapping(value = "/user/modify")
	public String modifyInfo(User user) {
		
		userService.update(user);
		return "";
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
		
		List<User> userList = userService.findByPage(pageNow, 10);
		int allPages = userService.userCnt();
		model.addAttribute("userList", userList);
		model.addAttribute("allPages", allPages);
		return "/manage/pages/" + pageNow;
	}
}
