package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// 反馈
@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue
	@Column(name = "fid", nullable = false)
	private int fid;

	@GeneratedValue
	@Column(name = "ftime", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private String ftime;

	@GeneratedValue
	@Column(name = "fcontent", nullable = false)
	private String fcontent;

	@GeneratedValue
	@Column(name = "ftel", nullable = true)
	private String ftel;

	@GeneratedValue
	@Column(name = "fstate", nullable = false)
	private int fstate = 0;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFtime() {
		return ftime;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

	public String getFtel() {
		return ftel;
	}

	public void setFtel(String ftel) {
		this.ftel = ftel;
	}

	public int getFstate() {
		return fstate;
	}

	public void setFstate(int fstate) {
		this.fstate = fstate;
	}

}
