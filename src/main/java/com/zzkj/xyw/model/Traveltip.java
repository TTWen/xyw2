package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


// 旅游攻略
@Entity
@Table(name = "traveltip")
public class Traveltip {

	@Id
	@GeneratedValue
	@Column(name = "ttid", nullable = false)
	private int ttid;//帖子id
	
	@GeneratedValue
	@Column(name = "ttime", columnDefinition ="timestamp default CURRENT_TIMESTAMP")
	private String ttime;//发帖时间
	
	@GeneratedValue
	@Column(name = "ttuid", nullable = false)
	private int ttuid;//发帖人id
	
	@GeneratedValue
	@Column(name = "tttitle", nullable = false)
	private String tttitle;//标题
	
	@GeneratedValue
	@Column(name = "ttcontent", nullable = false)
	private String ttcontent;//正文内容

	
	@GeneratedValue
	@Column(name = "ttview", columnDefinition ="default 0")
	private int ttview;//浏览量
	
	@GeneratedValue
	@Column(name = "ttlike", columnDefinition ="default 0")
	private int ttlike;//点赞量
	
	@GeneratedValue
	@Column(name = "tttsmt", columnDefinition ="default 0")
	private int tttsmt;//转发量
	
	@GeneratedValue
	@Column(name = "ttcmt", columnDefinition ="default 0")
	private int ttcmt;//评论量
	
	@GeneratedValue
	@Column(name = "ttpic", nullable = false)
	private String ttpic="/traveltippic/default.jpg"; // 封面图

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

	public String getTttitle() {
		return tttitle;
	}

	public void setTttitle(String tttitle) {
		this.tttitle = tttitle;
	}

	public String getTtcontent() {
		return ttcontent;
	}

	public void setTtcontent(String ttcontent) {
		this.ttcontent = ttcontent;
	}

	public int getTtview() {
		return ttview;
	}

	public void setTtview(int ttview) {
		this.ttview = ttview;
	}

	public int getTtlike() {
		return ttlike;
	}

	public void setTtlike(int ttlike) {
		this.ttlike = ttlike;
	}

	public int getTttsmt() {
		return tttsmt;
	}

	public void setTttsmt(int tttsmt) {
		this.tttsmt = tttsmt;
	}

	public int getTtcmt() {
		return ttcmt;
	}

	public void setTtcmt(int ttcmt) {
		this.ttcmt = ttcmt;
	}

	public String getTtpic() {
		return ttpic;
	}

	public void setTtpic(String ttpic) {
		this.ttpic = ttpic;
	}

	@Override
	public String toString() {
		return "Traveltip [ttid=" + ttid + ", ttime=" + ttime + ", ttuid="
				+ ttuid + ", tttitle=" + tttitle + ", ttcontent=" + ttcontent
				+ ", ttview=" + ttview + ", ttlike=" + ttlike + ", tttsmt="
				+ tttsmt + ", ttcmt=" + ttcmt + ", ttpic=" + ttpic + "]";
	}

	
	
	
}
