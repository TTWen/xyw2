package com.xt.ebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ebook.dao.IBookDAO;
import com.xt.ebook.model.Book;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDAO bookDao;
	
	public void create(Book bk) {
		// TODO Auto-generated method stub
		bookDao.add(bk);

	}

	public void delete(Book bk) {
		// TODO Auto-generated method stub
		bookDao.delete(bk);

	}

	public void update(Book bk) {
		// TODO Auto-generated method stub
		bookDao.update(bk);

	}

	// 普通分页
	public List<Book> findByPage(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return bookDao.findByPage(pageNow, pageSize);
	}

	public int bookCnt() {
		// TODO Auto-generated method stub
		String hql = "select count(1) from book as b";
		return bookDao.cnt(hql);
	}

	public List<Book> rank() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public List<Book> findByPrice(int pageNow, int pageSize, String orderBy,
			boolean isAsc, float min, float max) {
		// TODO Auto-generated method stub
		return bookDao.findByPage(pageNow, pageSize, orderBy, isAsc, min, max);
	}

	public List<Book> findByKeyword(int pageNow, int pageSize, String orderBy,
			boolean isAsc, String keyword) {
		// TODO Auto-generated method stub
		return bookDao.findByPage(pageNow, pageSize, orderBy, isAsc, keyword);
	}

}
