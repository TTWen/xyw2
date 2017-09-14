package com.xt.ebook.service;

import java.util.List;

import com.xt.ebook.model.Picture;

public interface IPictureService {

	// 添加图片
	public void add(String pbid, List<String> purl);
	
	// 批量删除某一图书的图片
	public void delete(String pbid, List<String> purl);
	
	// 图片一览
	public List<Picture> findByPbid(String pbid);
}
