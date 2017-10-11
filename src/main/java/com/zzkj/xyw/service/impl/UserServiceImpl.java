package com.zzkj.xyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.IUserDAO;
import com.zzkj.xyw.model.User;
import com.zzkj.xyw.service.IUserService;

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

	public User findById(int uid) {
		
		return userDao.findById(uid);
	}

}
