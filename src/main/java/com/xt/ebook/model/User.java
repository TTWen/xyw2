package com.xt.ebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "uid", nullable = false)
	private int uid;
	
	@Column(name = "uname", nullable = false)
	private String uname;
	
	@Column(name = "upsw", nullable = false)
	private String upsw;
	
	@Column(name = "utel", nullable = false)
	private String utel;
	
	@Column(name = "uem", nullable = false)
	private String uem;
	
	@Column(name = "uad", nullable = false)
	private String uad;
	
	@Column(name = "uurl", nullable = true)
	private String uurl;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpsw() {
		return upsw;
	}

	public void setUpsw(String upsw) {
		this.upsw = upsw;
	}

	public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	public String getUem() {
		return uem;
	}

	public void setUem(String uem) {
		this.uem = uem;
	}

	public String getUad() {
		return uad;
	}

	public void setUad(String uad) {
		this.uad = uad;
	}

	public String getUurl() {
		return uurl;
	}

	public void setUurl(String uurl) {
		this.uurl = uurl;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upsw=" + upsw
				+ ", utel=" + utel + ", uem=" + uem + ", uad=" + uad
				+ ", uurl=" + uurl + "]";
	}

}
