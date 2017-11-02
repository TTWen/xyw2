package com.zzkj.xyw.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.SimpleExpression;

import com.zzkj.xyw.model.Traveltip;

public interface ITraveltipService {

	// C
	public void create(Traveltip tt);

	// R

	//
	public List<Traveltip> findByPage(int pageNow, int pageSize);

	public List<Traveltip> findByPage(int pageNow, int pageSize,
			Criterion... criterion);

	public int cnt(Integer pageNow, int pageSize,
			List<Traveltip> traveltipList, HttpSession session);

	public Traveltip findById(int ttid);

	public List<Traveltip> findAll(List<Integer> ttids);

	// U
	public void update(Traveltip tt);

	// D
	public void delete(String[] tid);

	// cnt
	public int ttCnt();

	public int cnt(Criterion criterion);
}
