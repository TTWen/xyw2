package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


//主题
@Entity
@Table(name = "topic")
public class Topic {

	@Id
	@GeneratedValue
	@Column(name = "tpid", nullable = false)
	private int tpid;
	
	@Column(name = "tpuid", nullable = false)
	private int tpuid;
	
	@Column(name = "tpcontent", nullable = false)
	private String tpcontent;
	
	@Column(name = "tptime", columnDefinition ="timestamp default CURRENT_TIMESTAMP")
	private String tptime;

	@Column(name = "tpttid", nullable = false)
	private int tpttid;

	public int getTpid() {
		return tpid;
	}

	public void setTpid(int tpid) {
		this.tpid = tpid;
	}

	public int getTpuid() {
		return tpuid;
	}

	public void setTpuid(int tpuid) {
		this.tpuid = tpuid;
	}

	public String getTpcontent() {
		return tpcontent;
	}

	public void setTpcontent(String tpcontent) {
		this.tpcontent = tpcontent;
	}

	public String getTptime() {
		return tptime;
	}

	public void setTptime(String tptime) {
		this.tptime = tptime;
	}

	public int getTpttid() {
		return tpttid;
	}

	public void setTpttid(int tpttid) {
		this.tpttid = tpttid;
	}
	
	
}
