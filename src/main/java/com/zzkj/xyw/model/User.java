package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "uid", nullable = false)
	private int uid;

	@Column(name = "uname", nullable = false)
	private String uname;

	@Column(name = "upsw", nullable = false)
	private String upsw;

	@Column(name = "uicon", nullable = false)
	private String uicon = "/usericon/default.jepg";

	@Column(name = "utel", nullable = true)
	private String utel;

	@Column(name = "uemail", nullable = false)
	private String uemail;

	@Column(name = "ubirth", nullable = true)
	private String ubirth;

	@Column(name = "uregtime", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private String uregtime;

	@Column(name = "usignature", nullable = true)
	private String usignature;

	@Column(name = "usex", nullable = false)
	private String usex = "";

	@Column(name = "uisreal", nullable = false)
	private String uisreal = "0";

	public String getUicon() {
		return uicon;
	}

	public void setUicon(String uicon) {
		this.uicon = uicon;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpsw() {
		return upsw;
	}

	public void setUpsw(String upsw) {
		this.upsw = upsw;
	}

	public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUbirth() {
		return ubirth;
	}

	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}

	public String getUregtime() {
		return uregtime;
	}

	public void setUregtime(String uregtime) {
		this.uregtime = uregtime;
	}

	public String getUsignature() {
		return usignature;
	}

	public void setUsignature(String usignature) {
		this.usignature = usignature;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUisreal() {
		return uisreal;
	}

	public void setUisreal(String uisreal) {
		this.uisreal = uisreal;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upsw=" + upsw
				+ ", uicon=" + uicon + ", utel=" + utel + ", uemail=" + uemail
				+ ", ubirth=" + ubirth + ", uregtime=" + uregtime
				+ ", usignature=" + usignature + ", usex=" + usex
				+ ", uisreal=" + uisreal + "]";
	}

}
