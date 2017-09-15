package com.xt.ebook.service;

import java.util.List;

import com.xt.ebook.model.Sort;

public interface ISortService {

	public void add(Sort sort);
	
	public void delete(String[] sid);
	
	public List<Sort> findAll();
}
