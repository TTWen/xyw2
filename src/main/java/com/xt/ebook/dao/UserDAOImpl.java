package com.xt.ebook.dao;

import org.springframework.stereotype.Repository;

import com.xt.ebook.model.User;

@Repository("userDao")
public class UserDAOImpl extends BaseDAOImpl<User, String> implements IUserDAO {

	
}
