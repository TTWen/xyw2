package com.xt.ebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//分类号
@Entity
@Table(name = "sort")
public class Sort {

	@Id
	@GeneratedValue
	@Column(name = "sid", nullable = false)
	private int sid;

	@Column(name = "sname", nullable = false)
	private String sname;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Sort [sid=" + sid + ", sname=" + sname + "]";
	}
	
}
