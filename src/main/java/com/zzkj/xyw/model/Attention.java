package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


// 关注好友
@Entity
@Table(name = "attention")
public class Attention {

	@Id
	@GeneratedValue
	@Column(name = "aid", nullable = false)
	private int aid;
	
	//用户id
	@GeneratedValue
	@Column(name = "auid", nullable = false)
	private int auid;
	
	//被关注用户id
	@GeneratedValue
	@Column(name = "aduid", nullable = false)
	private int aduid;
	
	@GeneratedValue
	@Column(name = "atime", nullable = false)
	private String atime;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getAuid() {
		return auid;
	}

	public void setAuid(int auid) {
		this.auid = auid;
	}

	public int getAduid() {
		return aduid;
	}

	public void setAduid(int aduid) {
		this.aduid = aduid;
	}

	public String getAtime() {
		return atime;
	}

	public void setAtime(String atime) {
		this.atime = atime;
	}
	
	
}
