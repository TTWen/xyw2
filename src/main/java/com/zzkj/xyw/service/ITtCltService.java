package com.zzkj.xyw.service;


import java.util.List;

import com.zzkj.xyw.model.TtClt;

public interface ITtCltService {

		// C
		public void create(TtClt clt);
		
		// R
		public List<TtClt> findByPage(int pageNow, int pageSize, int cuid);

		// D
		public void delete(String criteria);
		
		public int cnt(int uid);
}
