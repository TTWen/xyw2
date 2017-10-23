package com.zzkj.xyw.service;

import java.util.List;

import com.zzkj.xyw.model.Traveltip;

public interface ITraveltipService {

	// C
	public void create(Traveltip tt);

	// R
	public List<Traveltip> findByPage(int pageNow, int pageSize);

	public Traveltip findById(int ttid);

	public List<Traveltip> findAll(List<Integer> ttids);

	// U
	public void update(Traveltip tt);

	// D
	public void delete(String[] tid);

	// cnt
	public int ttCnt();
}
