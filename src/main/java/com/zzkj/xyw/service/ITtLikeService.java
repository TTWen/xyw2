package com.zzkj.xyw.service;


import java.util.List;

import com.zzkj.xyw.model.TtLike;

public interface ITtLikeService {

		// C
		public void create(TtLike clt);
		
		// R
		public List<TtLike> findByIds(String ids);
//		public List<Traveltip> findByPage(int pageNow, int pageSize);
		
		// D
		public void delete(String[] lid);
}
