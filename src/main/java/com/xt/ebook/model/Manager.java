package com.xt.ebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager {

	@Id
	@GeneratedValue
	@Column(name = "mid", nullable = false)
	private int mid;

	@Column(name = "mname", nullable = false)
	private String mname;

	@Column(name = "mpsw", nullable = false)
	private String mpsw;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpsw() {
		return mpsw;
	}

	public void setMpsw(String mpsw) {
		this.mpsw = mpsw;
	}

	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", mname=" + mname + ", mpsw=" + mpsw
				+ "]";
	}

}
