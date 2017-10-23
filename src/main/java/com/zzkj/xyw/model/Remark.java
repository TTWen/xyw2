package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//主题评论
@Entity
@Table(name = "remark")
public class Remark {

	@Id
	@GeneratedValue
	@Column(name = "rid", nullable = false)
	private int rid;

	@Column(name = "ruid", nullable = false)
	private int ruid;

	@Column(name = "rduid", nullable = false)
	private int rduid;

	@Column(name = "rcontent", nullable = false)
	private String rcontent;

	@Column(name = "rtime", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private String rtime;

	@Column(name = "rtpid", nullable = false)
	private int rtpid;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getRuid() {
		return ruid;
	}

	public void setRuid(int ruid) {
		this.ruid = ruid;
	}

	public int getRduid() {
		return rduid;
	}

	public void setRduid(int rduid) {
		this.rduid = rduid;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	public int getRtpid() {
		return rtpid;
	}

	public void setRtpid(int rtpid) {
		this.rtpid = rtpid;
	}

}
