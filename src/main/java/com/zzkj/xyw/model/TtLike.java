package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//攻略点赞
@Entity
@Table(name = "ttlike")
public class TtLike {

	@Id
	@GeneratedValue
	@Column(name = "lid", nullable = false)
	private int lid;

	@GeneratedValue
	@Column(name = "luid", nullable = false)
	private int luid;

	@GeneratedValue
	@Column(name = "lttid", nullable = false)
	private int lttid;

	@GeneratedValue
	@Column(name = "ltime", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private String ltime;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getLuid() {
		return luid;
	}

	public void setLuid(int luid) {
		this.luid = luid;
	}

	public int getLttid() {
		return lttid;
	}

	public void setLttid(int lttid) {
		this.lttid = lttid;
	}

	public String getLtime() {
		return ltime;
	}

	public void setLtime(String ltime) {
		this.ltime = ltime;
	}

}
