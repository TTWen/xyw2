package com.xt.ebook.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<User> login(String uname, String upsw) {
		
		String hql = "from User u where u.uname=? and u.upsw=?";
		return userDao.find(hql, new String[]{uname, upsw});
	}
	
	public List<User> findByPage(int pageNow, int pageSize) {
		
		return userDao.findByPage(pageNow, pageSize);
	}

	public int userCnt() {
		
		String hql = "select count(1) from User as u";
		return userDao.cnt(hql);
	}

	public void update(User user) {
		
		userDao.update(user);
	}

}
