package com.xt.ebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue
	@Column(name = "bid", nullable = false)
	private int bid;

	@Column(name = "bname", nullable = false)
	private String bname;

	@Column(name = "bauth", nullable = false)
	private String bauth;

	@Column(name = "bpdate", nullable = false)
	private String bpdate;

	@Column(name = "bisbn", nullable = false)
	private String bisbn;

	@Column(name = "bpurpr", nullable = false)
	private float bpurpr;

	@Column(name = "bsalepr", nullable = false)
	private float bsalepr;

	@Column(name = "stock", nullable = false)
	private int stock;

	@Column(name = "bpurnum", nullable = false)
	private int bpurnum;

	@Column(name = "bsalenum", nullable = false)
	private int bsalenum;

	@Column(name = "bexpl", nullable = false)
	private String bexpl;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauth() {
		return bauth;
	}

	public void setBauth(String bauth) {
		this.bauth = bauth;
	}

	public String getBpdate() {
		return bpdate;
	}

	public void setBpdate(String bpdate) {
		this.bpdate = bpdate;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public float getBpurpr() {
		return bpurpr;
	}

	public void setBpurpr(float bpurpr) {
		this.bpurpr = bpurpr;
	}

	public float getBsalepr() {
		return bsalepr;
	}

	public void setBsalepr(float bsalepr) {
		this.bsalepr = bsalepr;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getBpurnum() {
		return bpurnum;
	}

	public void setBpurnum(int bpurnum) {
		this.bpurnum = bpurnum;
	}

	public int getBsalenum() {
		return bsalenum;
	}

	public void setBsalenum(int bsalenum) {
		this.bsalenum = bsalenum;
	}

	public String getBexpl() {
		return bexpl;
	}

	public void setBexpl(String bexpl) {
		this.bexpl = bexpl;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", bauth=" + bauth
				+ ", bpdate=" + bpdate + ", bisbn=" + bisbn + ", bpurpr="
				+ bpurpr + ", bsalepr=" + bsalepr + ", stock=" + stock
				+ ", bpurnum=" + bpurnum + ", bsalenum=" + bsalenum
				+ ", bexpl=" + bexpl + "]";
	}

}
