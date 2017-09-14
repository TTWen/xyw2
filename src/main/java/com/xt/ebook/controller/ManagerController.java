package com.xt.ebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xt.ebook.model.Manager;
import com.xt.ebook.service.IManagerService;

@Controller
public class ManagerController {

	@Autowired
	private IManagerService mngService;
	
	// 返回登录 view
	@RequestMapping(value = "/manage/login")
	public String login() {
		
		return "/manage/login";
	}
	
	// 返回注册 view
	@RequestMapping(value = "/manage/register")
	public String register() {
		
		return "/manage/register";
	}
	
	// 登录
	@RequestMapping(value = "/manage/doLogin")
	public String doLogin(String mname, String mpsw) {
		
		List<Manager> li =  mngService.login(mname, mpsw);
		if( !li.isEmpty() ) {
			
			return "/manage/index";
		}
		return "/manage/login";
	}
	
	// 注册
	@RequestMapping(value = "/manage/doRegister")
	public String doRegister(Manager mng) {
		
		mngService.regist(mng);
		return "/manage/login";
	}
}
