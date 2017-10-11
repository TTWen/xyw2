package com.zzkj.xyw.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzkj.xyw.model.Manager;
import com.zzkj.xyw.service.IManagerService;

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
	
	// 返回注销 view
	@RequestMapping(value = "/manage/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("crtmid");
		return "redirect:/index";
	}
	
	// 登录
	@RequestMapping(value = "/manage/doLogin")
	public String doLogin(String mname, String mpsw, Model model, 
			HttpSession session) {
		
		List<Manager> li =  mngService.login(mname, mpsw);
		if( !li.isEmpty() ) {
			session.setAttribute("crtmid", li.get(0).getMid());
			return "redirect:/manage/admindex";
		} else {
			
			model.addAttribute("msg", "登录失败！");
			return "/manage/login";
		}
		
	}
	 
	// 注册
	@RequestMapping(value = "/manage/doRegister")
	public String doRegister(Manager mng, Model model) {
		
		mngService.regist(mng);
		model.addAttribute("msg", "注册成功！");
		List<Manager> mngList = mngService.findAll();
		model.addAttribute("mngList", mngList);
		return "/manage/manager";
	}
	
	// 删除
	@RequestMapping(value = "/manage/deleteMng")
	public String deleteMng(String [] mid, Model model) {
		
		mngService.delete(mid);
		List<Manager> mngList = mngService.findAll();
		model.addAttribute("mngList", mngList);
		return "/manage/manager";
	}
	
	// 管理员一览
	@RequestMapping(value = "/manage/manager")
	public String manager(Model model) {
		
		List<Manager> mngList = mngService.findAll();
		model.addAttribute("mngList", mngList);
		return "/manage/manager";
	}
	
	// 返回后台index view
	@RequestMapping(value = "/manage/admindex")
	public String index() {
		
		return "/manage/admindex";
	}
}
