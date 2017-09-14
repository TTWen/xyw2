package com.xt.ebook.service;

import java.util.List;

import com.xt.ebook.model.User;

public interface IUserService {

	
	public void regist(User user);
	
	public List<User> login(String uname, String upsw);

	public List<User> findByPage(int pageNow, int size);
	
	public User findById(int uid);
	
	public int userCnt();
	
	public void update(User user);
}
