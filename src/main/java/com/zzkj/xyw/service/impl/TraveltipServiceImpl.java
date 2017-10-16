package com.zzkj.xyw.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.ITraveltipDAO;
import com.zzkj.xyw.model.Traveltip;
import com.zzkj.xyw.service.ITraveltipService;

@Service("traveltipService")
public class TraveltipServiceImpl implements ITraveltipService {

	@Autowired
	private ITraveltipDAO traveltipDao;
	
	
	public void create(Traveltip tt) {
		// TODO Auto-generated method stub

		traveltipDao.add(tt);
	}

	public List<Traveltip> findByPage(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return traveltipDao.findByPage(pageNow, pageSize);
	}

	public void delete(String[] ttid) {
		// TODO Auto-generated method stub

		traveltipDao.delete(ttid, "ttid");
	}

	public int ttCnt() {
		// TODO Auto-generated method stub
		return traveltipDao.cnt("Traveltip");
	}

	public Traveltip findById(int ttid) {
		// TODO Auto-generated method stub
		return traveltipDao.findById(ttid);
	}

	public void update(Traveltip tt) {
		// TODO Auto-generated method stub
		traveltipDao.update(tt);
		
	}

	public List<Traveltip> findAll(List<Integer> ttids) {
		// TODO Auto-generated method stub
		
		return traveltipDao.findAll(Restrictions.in("ttid", ttids));
	}

}
