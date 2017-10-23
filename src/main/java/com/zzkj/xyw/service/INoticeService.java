package com.zzkj.xyw.service;

import java.util.List;

import com.zzkj.xyw.model.Notice;

public interface INoticeService {

	// C
	public void create(Notice ntc);

	// R
	public List<Notice> findByPage(int pageNow, int pageSize);

	// D
	public void delete(String[] nid);

	// cnt
	public int noticeCnt();
}
