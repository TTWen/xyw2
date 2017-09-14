package com.xt.ebook.dao;

import org.springframework.stereotype.Repository;

import com.xt.ebook.model.Book;

@Repository
public class BookDAOImpl extends BaseDAOImpl<Book, String> implements IBookDAO {

}
