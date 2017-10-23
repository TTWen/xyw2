package com.zzkj.xyw.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzkj.xyw.dao.IUserDAO;
import com.zzkj.xyw.model.User;

@Repository("userDao")
public class UserDAOImpl extends BaseDAOImpl<User, String> implements IUserDAO {

}
