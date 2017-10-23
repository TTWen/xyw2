package com.zzkj.xyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.IManagerDAO;
import com.zzkj.xyw.model.Manager;
import com.zzkj.xyw.service.IManagerService;

@Service
public class ManagerServiceImpl implements IManagerService {

	@Autowired
	private IManagerDAO mngDao;

	public void regist(Manager mng) {
		// TODO Auto-generated method stub

		mngDao.add(mng);
	}

	public List<Manager> login(String mname, String mpsw) {
		// TODO Auto-generated method stub
		String hql = "from Manager m where m.mname=? and m.mpsw=?";
		return mngDao.find(hql, new String[] { mname, mpsw });
	}

	public List<Manager> findAll() {
		// TODO Auto-generated method stub
		return mngDao.find("from Manager", null);
	}

	public void delete(String[] mid) {
		// TODO Auto-generated method stub
		mngDao.delete(mid, "mid");
	}

	public Manager findById(int mid) {
		// TODO Auto-generated method stub

		return mngDao.findById(mid);
	}

}
