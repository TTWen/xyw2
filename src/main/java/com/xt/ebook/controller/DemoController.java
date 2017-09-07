package com.xt.ebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

	@RequestMapping(value = "login")
    public String login() {
        return "login";
    }

	@RequestMapping(value = "index")
    public String index() {
		return "index";
    }
	
	@RequestMapping(value = "dologin", method = {RequestMethod.POST})
	public String dologin(String uname){
		System.out.println(uname);
		if("uname".equals(null)) {
			return "login";
		}
		return "demo";
	}
	
}