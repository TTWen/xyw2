package com.xt.ebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ebook.dao.ISortDAO;
import com.xt.ebook.model.Sort;

@Service
public class SortServiceImpl implements ISortService {

	@Autowired
	private ISortDAO sortDao;
	
	public void add(Sort sort) {
		
		sortDao.add(sort);
	}

	public void delete(String[] sid) {
		
		sortDao.delete(sid, "sid");
	}

	public List<Sort> findAll() {
		
		return sortDao.findByPage(0, 100);
	}

}
