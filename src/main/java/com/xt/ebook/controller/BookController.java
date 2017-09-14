package com.xt.ebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xt.ebook.model.Sort;
import com.xt.ebook.service.IBookService;
import com.xt.ebook.service.IManagerService;
import com.xt.ebook.service.ISortService;

@Controller
public class BookController {

	@Autowired
	private IBookService bookService;
	@Autowired
	private ISortService sortService;
	
	@RequestMapping(value = "/book/search")
	public String searchBylike(String keyword) {
		
		bookService.findByKeyword(0, 10, "bsalenum", true, keyword);
		return "/manage/products";
	}
	
	@RequestMapping(value = "/manage/sort")
	public String allSort(Model model){
		
		List<Sort> li = sortService.findAll();
		model.addAttribute("sortList", li);
		return "/manage/sort";
	}
	
	@RequestMapping(value = "/manage/sort/add")
	public String addSort(){
		
		return "/manage/addSort";
	}
	
	@RequestMapping(value = "/manage/addSort")
	public String addSort(Sort sort, Model model){
		
		sortService.add(sort);
		model.addAttribute("sortList", sortService.findAll());
		return "/manage/sort";
	}
}
