package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//公告
@Entity
@Table(name = "notice")
public class Notice {

	@Id
	@GeneratedValue
	@Column(name = "nid", nullable = false)
	private int nid;

	// 发布公告的管理员
	@Column(name = "nmid", nullable = false)
	private int nmid;

	@Column(name = "ntitle", nullable = false)
	private String ntitle;

	@Column(name = "ncontent", nullable = false)
	private String ncontent;

	@Column(name = "ntime", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private String ntime;

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getNmid() {
		return nmid;
	}

	public void setNmid(int nmid) {
		this.nmid = nmid;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNtime() {
		return ntime;
	}

	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

}
