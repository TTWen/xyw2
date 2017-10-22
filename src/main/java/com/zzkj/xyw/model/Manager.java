package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager {

	@Id
	@GeneratedValue
	@Column(name = "mid", nullable = false)
	private int mid;

	@Column(name = "mname", nullable = false)
	private String mname;

	@Column(name = "mpsw", nullable = false)
	private String mpsw="888888";

	@Column(name = "mtel", nullable = true)
	private String mtel;

	@Column(name = "memail", nullable = true)
	private String memail;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpsw() {
		return mpsw;
	}

	public void setMpsw(String mpsw) {
		this.mpsw = mpsw;
	}

	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

}
