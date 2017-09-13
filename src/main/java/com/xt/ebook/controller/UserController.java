package com.xt.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xt.ebook.model.User;
import com.xt.ebook.service.IUserService;
import com.xt.ebook.service.UserServiceImpl;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	// 返回登录 view
	@RequestMapping(value = "/login")
	public String login() {
		
		return "login";
	}
	
	// 返回注册 view
	@RequestMapping(value = "/regist")
	public String regist() {
		
		return "regist";
	}
	
	// 登录
	@RequestMapping(value = "/doLogin")
	public String doLogin(String uname, String upsw) {
		
		return "index";
	}
	
	// 注册
	@RequestMapping(value = "/doRegist")
	public String doRegist(User user) {
		System.out.println(user.toString());
		userService.regist(user);
		return "login";
	}
	
}
