package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


// 景点
@Entity
@Table(name = "scene")
public class Scene {

	@Id
	@GeneratedValue
	@Column(name = "sid", nullable = false)
	private int sid;
	
	@GeneratedValue
	@Column(name = "sintrod", nullable = false)
	private String sintrod;
	
	
	@GeneratedValue
	@Column(name = "spic", nullable = false)
	private String spic="/scenepic/default.jpg";
	
	@GeneratedValue
	@Column(name = "scity", nullable = false)
	private String scity;

	@GeneratedValue
	@Column(name = "sprovince", nullable = true)
	private String sprovince;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSintrod() {
		return sintrod;
	}

	public void setSintrod(String sintrod) {
		this.sintrod = sintrod;
	}

	public String getSpic() {
		return spic;
	}

	public void setSpic(String spic) {
		this.spic = spic;
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	public String getSprovince() {
		return sprovince;
	}

	public void setSprovince(String sprovince) {
		this.sprovince = sprovince;
	}

	
	
}
