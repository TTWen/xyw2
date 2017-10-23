package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// 攻略收藏
@Entity
@Table(name = "ttclt")
public class TtClt {

	@Id
	@GeneratedValue
	@Column(name = "cid", nullable = false)
	private int cid;

	@GeneratedValue
	@Column(name = "cuid", nullable = false)
	private int cuid;

	@GeneratedValue
	@Column(name = "cttid", nullable = false)
	private int cttid;

	@GeneratedValue
	@Column(name = "ctime", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private String ctime;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCuid() {
		return cuid;
	}

	public void setCuid(int cuid) {
		this.cuid = cuid;
	}

	public int getCttid() {
		return cttid;
	}

	public void setCttid(int cttid) {
		this.cttid = cttid;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

}
