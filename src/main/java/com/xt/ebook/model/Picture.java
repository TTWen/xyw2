package com.xt.ebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// 图书图片
@Entity
@Table(name = "picture")
public class Picture {

	@Id
	@GeneratedValue
	@Column(name = "pid", nullable = false)
	private int pid;

	@Column(name = "pbid", nullable = false)
	private String pbid;

	@Column(name = "purl", nullable = false)
	private String bauth;


}
