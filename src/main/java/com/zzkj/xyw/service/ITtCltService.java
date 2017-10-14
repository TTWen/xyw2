package com.zzkj.xyw.service;


import com.zzkj.xyw.model.TtClt;

public interface ITtCltService {

		// C
		public void create(TtClt clt);
		
		// R
//		public List<Traveltip> findByPage(int pageNow, int pageSize);
		
		// D
		public void delete(String[] cid);
}
