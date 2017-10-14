package com.zzkj.xyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzkj.xyw.dao.ITtLikeDAO;
import com.zzkj.xyw.model.TtLike;
import com.zzkj.xyw.service.ITtLikeService;

@Service("ttLikeService")
public class TtLikeService implements ITtLikeService {

	@Autowired
	private ITtLikeDAO ttLikeDao;
	
	public void create(TtLike like) {
		// TODO Auto-generated method stub

		ttLikeDao.add(like);
	}

	public void delete(String[] lttid) {
		// TODO Auto-generated method stub

		ttLikeDao.delete(lttid, "lttid");
	}

	public List<TtLike> findByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
