package com.xt.ebook.service;

import java.util.List;

import com.xt.ebook.model.Book;

public interface IBookService {

	// 新建
	public void create(Book bk);

	// 删除
	public void delete(String[] bid);

	// 修改信息
	public void update(Book bk);
	
	// 查询图书详细信息
	public Book findById(int id);

	// 图书分页
	public List<Book> findByPage(int pageNow, int pageSize);

	// 按价格区间搜索
	public List<Book> findByPrice(int pageNow, int pageSize, String orderBy,
			boolean isAsc, float min, float max);
	// 按关键字搜索
	public List<Book> findByKeyword(int pageNow, int pageSize, String orderBy,
			boolean isAsc, String keyword);
	
	// 总数
	public int bookCnt();

	// 排行榜（累计销量）
	public List<Book> rank();

}
