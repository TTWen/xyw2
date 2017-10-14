package com.zzkj.xyw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.ITtCltDAO;
import com.zzkj.xyw.model.TtClt;
import com.zzkj.xyw.service.ITtCltService;

@Service("ttCltService")
public class TtCltService implements ITtCltService {

	@Autowired
	private ITtCltDAO ttCltDao;
	
	public void create(TtClt clt) {
		// TODO Auto-generated method stub

		ttCltDao.add(clt);
	}

	// 按照攻略id取消 而非收藏id
	public void delete(String[] cttid) {
		// TODO Auto-generated method stub

		ttCltDao.delete(cttid, "cttid");
	}

}
