package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reserve")
public class Reserve {

	@Id
	@GeneratedValue
	@Column(name = "reid", nullable = false)
	private int reid;  //预约id
	
	@GeneratedValue
	@Column(name = "rebegin", nullable = false)
	private String rebegin; //预约开始时间
	
	@GeneratedValue
	@Column(name = "refinsh", nullable = false)
	private String refinsh; //预约结束时间
	
	@GeneratedValue
	@Column(name = "reuid", nullable = false)
	private int reuid; //预约用户id
	
	@GeneratedValue
	@Column(name = "reduid", nullable = false)
	private int reduid; //被预约用户id
	
	@GeneratedValue
	@Column(name = "restatus", nullable = false)
	private String restatus; //预约状态

	public int getReid() {
		return reid;
	}

	public void setReid(int reid) {
		this.reid = reid;
	}

	public String getRebegin() {
		return rebegin;
	}

	public void setRebegin(String rebegin) {
		this.rebegin = rebegin;
	}

	public String getRefinsh() {
		return refinsh;
	}

	public void setRefinsh(String refinsh) {
		this.refinsh = refinsh;
	}

	public int getReuid() {
		return reuid;
	}

	public void setReuid(int reuid) {
		this.reuid = reuid;
	}

	public int getReduid() {
		return reduid;
	}

	public void setReduid(int reduid) {
		this.reduid = reduid;
	}

	public String getRestatus() {
		return restatus;
	}

	public void setRestatus(String restatus) {
		this.restatus = restatus;
	}
	
	
}
