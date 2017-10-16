package com.zzkj.xyw.service;


import java.util.List;

import com.zzkj.xyw.model.TraveltipOp;
import com.zzkj.xyw.model.TtLike;

public interface ITtLikeService {

		// C
		public void create(TtLike clt);
		
		// R
		
		public List<TraveltipOp> findAll(List<Integer> ttids, int luid);
//		public List<Traveltip> findByPage(int pageNow, int pageSize);
		
		// D
		public void delete(String criteria);
}
