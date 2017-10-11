package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetail")
public class UserDetail {

	@Id
	@GeneratedValue
	@Column(name = "udid", nullable = false)
	private String udid;
	
	@GeneratedValue
	@Column(name = "udattcnt", nullable = false)
	private String udattcnt; 
	
	@GeneratedValue
	@Column(name = "udfanscnt", nullable = false)
	private String udfanscnt; 
	
	@GeneratedValue
	@Column(name = "udcoincnt", nullable = false)
	private String udcoincnt; 
	
	@GeneratedValue
	@Column(name = "udexp", nullable = false)
	private String udexp; //  经验
	
	@GeneratedValue
	@Column(name = "udlastlog", nullable = false)
	private String udlastlog; // 上次登录时间

	public String getUdid() {
		return udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	public String getUdattcnt() {
		return udattcnt;
	}

	public void setUdattcnt(String udattcnt) {
		this.udattcnt = udattcnt;
	}

	public String getUdfanscnt() {
		return udfanscnt;
	}

	public void setUdfanscnt(String udfanscnt) {
		this.udfanscnt = udfanscnt;
	}

	public String getUdcoincnt() {
		return udcoincnt;
	}

	public void setUdcoincnt(String udcoincnt) {
		this.udcoincnt = udcoincnt;
	}

	public String getUdexp() {
		return udexp;
	}

	public void setUdexp(String udexp) {
		this.udexp = udexp;
	}

	public String getUdlastlog() {
		return udlastlog;
	}

	public void setUdlastlog(String udlastlog) {
		this.udlastlog = udlastlog;
	}
	
	
}
