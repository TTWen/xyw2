package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


// 旅游攻略
@Entity
@Table(name = "traveltip")
public class TravelTip {

	@Id
	@GeneratedValue
	@Column(name = "ttid", nullable = false)
	private int ttid;//帖子id
	
	@GeneratedValue
	@Column(name = "ttime", nullable = false)
	private String ttime;//发帖时间
	
	@GeneratedValue
	@Column(name = "ttuid", nullable = false)
	private int ttuid;//发帖人id
	
	@GeneratedValue
	@Column(name = "tttile", nullable = false)
	private String tttile;//标题
	
	@GeneratedValue
	@Column(name = "ttcontent", nullable = false)
	private String ttcontent;//正文内容

	
	@GeneratedValue
	@Column(name = "ttviewcnt", nullable = false)
	private int ttviewcnt;//浏览量
	
	@GeneratedValue
	@Column(name = "ttlikecnt", nullable = false)
	private int ttlikecnt;//点赞量
	
	@GeneratedValue
	@Column(name = "tttsmtcnt", nullable = false)
	private int tttsmtcnt;//转发量
	
	@GeneratedValue
	@Column(name = "ttcmtcnt", nullable = false)
	private int ttcmtcnt;//评论量

	public int getTtid() {
		return ttid;
	}

	public void setTtid(int ttid) {
		this.ttid = ttid;
	}

	public String getTtime() {
		return ttime;
	}

	public void setTtime(String ttime) {
		this.ttime = ttime;
	}

	public int getTtuid() {
		return ttuid;
	}

	public void setTtuid(int ttuid) {
		this.ttuid = ttuid;
	}

	public String getTttile() {
		return tttile;
	}

	public void setTttile(String tttile) {
		this.tttile = tttile;
	}

	public String getTtcontent() {
		return ttcontent;
	}

	public void setTtcontent(String ttcontent) {
		this.ttcontent = ttcontent;
	}

	public int getTtviewcnt() {
		return ttviewcnt;
	}

	public void setTtviewcnt(int ttviewcnt) {
		this.ttviewcnt = ttviewcnt;
	}

	public int getTtlikecnt() {
		return ttlikecnt;
	}

	public void setTtlikecnt(int ttlikecnt) {
		this.ttlikecnt = ttlikecnt;
	}

	public int getTttsmtcnt() {
		return tttsmtcnt;
	}

	public void setTttsmtcnt(int tttsmtcnt) {
		this.tttsmtcnt = tttsmtcnt;
	}

	public int getTtcmtcnt() {
		return ttcmtcnt;
	}

	public void setTtcmtcnt(int ttcmtcnt) {
		this.ttcmtcnt = ttcmtcnt;
	}
	
	
}
