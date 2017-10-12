package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//闲置物品
@Entity
@Table(name = "idle")
public class Idle {
	
	@Id
	@GeneratedValue
	@Column(name = "iid", nullable = false)
	private int iid;//闲置物品id
	
	@GeneratedValue
	@Column(name = "iuid", nullable = false)
	private int iuid;//闲置物品拥有者用户id
	
	@GeneratedValue
	@Column(name = "iname", nullable = false)
	private String iname;//闲置物品名称
	
	@GeneratedValue
	@Column(name = "idetail", nullable = false)
	private String idetail;//存放闲置物品的详情描述
	
	@GeneratedValue
	@Column(name = "itype", nullable = false)
	private boolean itype;//存放闲置物品的类型，forfree还是forsale
	
	@GeneratedValue
	@Column(name = "itime", columnDefinition ="timestamp default CURRENT_TIMESTAMP")
	private String itime;//存放闲置物品的发布时间

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public int getIuid() {
		return iuid;
	}

	public void setIuid(int iuid) {
		this.iuid = iuid;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getIdetail() {
		return idetail;
	}

	public void setIdetail(String idetail) {
		this.idetail = idetail;
	}

	public boolean isItype() {
		return itype;
	}

	public void setItype(boolean itype) {
		this.itype = itype;
	}

	public String getItime() {
		return itime;
	}

	public void setItime(String itime) {
		this.itime = itime;
	}
	
	
}