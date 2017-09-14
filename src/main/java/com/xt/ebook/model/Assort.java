package com.xt.ebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


// 图书分类
@Entity
@Table(name = "assort")
public class Assort {

	@Id
	@GeneratedValue
	@Column(name = "aid", nullable = false)
	private int aid;

	@Column(name = "abid", nullable = false)
	private int abid;
	
	@Column(name = "asid", nullable = false)
	private int asid;
}
