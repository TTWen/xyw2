package com.xt.ebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ebook.dao.IPictureDAO;
import com.xt.ebook.model.Picture;

@Service
public class PictureServiceImpl implements IPictureService {

	@Autowired
	private IPictureDAO picDao;
	
	public void add(String pbid, List<String> purl) {
		// TODO Auto-generated method stub

	}

	public void delete(String pbid, List<String> purl) {
		// TODO Auto-generated method stub

	}

	public List<Picture> findByPbid(String pbid) {
		// TODO Auto-generated method stub
		return null;
	}

}
