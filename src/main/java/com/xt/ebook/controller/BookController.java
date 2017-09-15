package com.xt.ebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xt.ebook.model.Book;
import com.xt.ebook.model.Sort;
import com.xt.ebook.model.User;
import com.xt.ebook.service.IBookService;
import com.xt.ebook.service.ISortService;

@Controller
public class BookController {

	@Autowired
	private IBookService bookService;
	@Autowired
	private ISortService sortService;

	// 图书检索
	@RequestMapping(value = "/book/search/{pageNow}")
	public String searchBylike(@PathVariable int pageNow, String keyword,
			Model model) {

		int pageSize = 12;

		List<Book> bookList = bookService.findByKeyword(pageNow, pageSize,
				"bsalenum", true, keyword);
		int liSize = bookService.findByKeyword(keyword).size();
		int allPages = (liSize - 1)/pageSize + 1;
		model.addAttribute("bookList", bookList);
		model.addAttribute("allPages", allPages);
		model.addAttribute("pageNow", pageNow);
		return "/products";
	}

	// 所有图书
	@RequestMapping(value = "/products/{pageNow}")
	public String products(@PathVariable int pageNow, Model model) {
		int pageSize = 2;
		List<Book> bookList = bookService.findByPage(pageNow, pageSize);
		// 没考虑cnt == 0
		int allPages = (bookService.bookCnt() -1)/pageSize + 1;
		model.addAttribute("bookList", bookList);
		model.addAttribute("pageNow", pageNow);
		model.addAttribute("allPages", allPages);
		return "/products";
	}
	
	// 添加图书 view
	@RequestMapping(value = "/manage/book/add")
	public String addBook() {

		return "/manage/addBook";
	}

	// 添加图书
	@RequestMapping(value = "/manage/book/addBook")
	public String addBook(Book book, Model model) {
		bookService.create(book);

		model.addAttribute("msg", "添加图书成功");
		return "success";
	}

	// 图书一览
	@RequestMapping(value = "/manage/book/{pageNow}")
	public String book(@PathVariable int pageNow, Model model) {
		int pageSize = 2;
		List<Book> bookList = bookService.findByPage(pageNow, pageSize);
		// 没考虑cnt == 0
		int allPages = (bookService.bookCnt() -1)/pageSize + 1;
		model.addAttribute("bookList", bookList);
		model.addAttribute("pageNow", pageNow);
		model.addAttribute("allPages", allPages);
		return "/manage/book";
	}
	// 图书一览
	@RequestMapping(value = "/manage/book")
	public String book2(@PathVariable int pageNow, Model model) {
		int pageSize = 2;
		List<Book> bookList = bookService.findByPage(0, pageSize);
		// 没考虑cnt == 0
		int allPages = (bookService.bookCnt() -1)/pageSize + 1;
		model.addAttribute("bookList", bookList);
		model.addAttribute("pageNow", pageNow);
		model.addAttribute("allPages", allPages);
		return "/manage/book";
	}

	// 图书修改 view
	@RequestMapping(value = "/manage/book/modify/{bid}")
	public String modifyBook(@PathVariable int bid, Model model) {

		Book book = bookService.findById(bid);
		model.addAttribute("b", book);
		return "/manage/modifyBook";
	}

	// 图书修改
	@RequestMapping(value = "/manage/modifyBook/{bid}")
	public String doModifyBook(@PathVariable int bid, Book book, Model model) {

		System.out.println(bid);
		book.setBid(bid);
		bookService.update(book);
		model.addAttribute("msg", "图书信息修改成功");
		return "success";
	}

	// 图书删除
	@RequestMapping(value = "/manage/deleteBook")
	public String deleteBook(String[] bid, Model model) {

		int pageSize = 2;
		bookService.delete(bid);
		List<Book> bookList = bookService.findByPage(0, pageSize);
		// 没考虑cnt == 0
		int allPages = (bookService.bookCnt() -1)/pageSize + 1;
		model.addAttribute("bookList", bookList);
		model.addAttribute("pageNow", 0);
		model.addAttribute("allPages", allPages);
		return "/manage/book";
	}
	
	// 返回所有图书分类list
	@RequestMapping(value = "/manage/sort")
	public String allSort(Model model) {

		List<Sort> li = sortService.findAll();
		model.addAttribute("sortList", li);
		return "/manage/sort";
	}

	// 添加图书分类 view
	@RequestMapping(value = "/manage/sort/add")
	public String addSort() {

		return "/manage/addSort";
	}

	// 添加图书分类
	@RequestMapping(value = "/manage/addSort")
	public String addSort(Sort sort, Model model) {

		sortService.add(sort);
		model.addAttribute("sortList", sortService.findAll());
		return "/manage/sort";
	}

	// 删除图书分类
	@RequestMapping(value = "/manage/deleteSort")
	public String deleteSort(String[] sid, Model model) {

		sortService.delete(sid);
		model.addAttribute("sortList", sortService.findAll());
		return "/manage/sort";
	}

}
