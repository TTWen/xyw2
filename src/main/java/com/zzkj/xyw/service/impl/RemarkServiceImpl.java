package com.zzkj.xyw.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.IRemarkDAO;
import com.zzkj.xyw.model.Remark;
import com.zzkj.xyw.service.IRemarkService;

@Service("remarkService")
public class RemarkServiceImpl implements IRemarkService{

	@Autowired
	private IRemarkDAO remarkDao;

	public void create(Remark rmk) {
		// TODO Auto-generated method stub
		remarkDao.add(rmk);
	}

	public List<Remark> findByPage(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return remarkDao.findByPage(pageNow, pageSize);
	}

	public void delete(String[] rid) {
		// TODO Auto-generated method stub
		remarkDao.delete(rid, "rid");
		
	}

	public int remarkCnt() {
		// TODO Auto-generated method stub
		
		return remarkDao.cnt("Remark");
	}

	public List<Remark> findAll(int tpid) {
		// TODO Auto-generated method stub
		return remarkDao.findAll(Restrictions.eq("rtpid", tpid));
	}
	
	
}
