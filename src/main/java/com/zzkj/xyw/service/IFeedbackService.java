package com.zzkj.xyw.service;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.zzkj.xyw.model.Feedback;
import com.zzkj.xyw.model.Traveltip;

public interface IFeedbackService {

	// C
	public void create(Feedback fb);

	// R
	public List<Feedback> findByPage(int pageNow, int pageSize, Criterion c);

	public Feedback findById(int id);
	// D
	public void delete(String[] id);

	// cnt
	public int cnt(Criterion c);
	
	public void update(Feedback fb);
}
