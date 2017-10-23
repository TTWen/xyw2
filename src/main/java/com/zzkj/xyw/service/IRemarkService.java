package com.zzkj.xyw.service;

import java.util.List;

import com.zzkj.xyw.model.Remark;

public interface IRemarkService {

	// C
	public void create(Remark ntc);

	// R
	public List<Remark> findByPage(int pageNow, int pageSize);

	// 查找某个评论下的所有回复
	public List<Remark> findAll(int tpid);

	// D
	public void delete(String[] rid);

	// cnt
	public int remarkCnt();
}
