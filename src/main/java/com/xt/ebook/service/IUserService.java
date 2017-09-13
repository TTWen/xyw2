package com.xt.ebook.service;

import com.xt.ebook.model.User;

public interface IUserService {

	public void regist(User user);
	
	public void login(String uname, String upsw);
	
	
}
