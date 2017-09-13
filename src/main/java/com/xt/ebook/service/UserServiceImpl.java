package com.xt.ebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ebook.dao.IUserDAO;
import com.xt.ebook.dao.UserDAOImpl;
import com.xt.ebook.model.User;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDao;
	
	public void regist(User user) {

		userDao.add(user);
	}

	public void login(String uname, String upsw) {
		
		
	}

}
