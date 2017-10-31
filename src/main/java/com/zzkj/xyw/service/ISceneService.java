package com.zzkj.xyw.service;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.zzkj.xyw.model.Scene;

public interface ISceneService {

	// C
	public void create(Scene scene);

	// R
	public List<Scene> findByPage(int pageNow, int pageSize, Criterion c);

	// D
	public void delete(String[] id);

	// cnt
	public int cnt(Criterion c);
	
	// U
	public void update(Scene scene);
}
