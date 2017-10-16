package com.zzkj.xyw.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.ITtCltDAO;
import com.zzkj.xyw.model.TtClt;
import com.zzkj.xyw.service.ITtCltService;

@Service("ttCltService")
public class TtCltServiceImpl implements ITtCltService {

	@Autowired
	private ITtCltDAO ttCltDao;
	
	public void create(TtClt clt) {
		// TODO Auto-generated method stub

		ttCltDao.add(clt);
	}

	// 按照攻略id取消 而非收藏id
	public void delete(String criteria) {
		// TODO Auto-generated method stub
		ttCltDao.delete(criteria);
	}

	public List<TtClt> findByPage(int pageNow, int pageSize, int cuid) {
		// TODO Auto-generated method stub
		return ttCltDao.findByPage(pageNow, pageSize, "ctime", false, 
				Restrictions.eq("cuid", cuid));
	}

	public int cnt(int uid) {
		// TODO Auto-generated method stub
		
		return ttCltDao.cnt("TtClt where cuid="+uid);
	}

}
