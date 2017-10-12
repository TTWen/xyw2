package com.zzkj.xyw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "real")
public class Real {

	@Id
	@GeneratedValue
	@Column(name = "rlid", nullable = false)
	private int rlid;//表示主键
	
	@GeneratedValue
	@Column(name = "rluid", nullable = false)
	private int rluid;//用户id
	
	@GeneratedValue
	@Column(name = "rlidcard", nullable = false)
	private String rlidcard;//身份证号码
	
	@GeneratedValue
	@Column(name = "rlname", nullable = false)
	private String rlname;//真实姓名
	
	@GeneratedValue
	@Column(name = "rlfileurl", nullable = false)
	private String rlfileurl;//真实资料地址
	
	@GeneratedValue
	@Column(name = "rliconurl", nullable = false)
	private String rliconurl;//真实头像
	
	@GeneratedValue
	@Column(name = "rladdr", nullable = false)
	private String rladdr;//地址
	
	@GeneratedValue
	@Column(name = "rlpost", nullable = false)
	private String rlpost;//邮编
	
	@GeneratedValue
	@Column(name = "rlschool", nullable = false)
	private String rlschool;//学校
	
	@GeneratedValue
	@Column(name = "major", nullable = false)
	private String major;//专业
	
	@GeneratedValue
	@Column(name = "qq", nullable = false)
	private String qq;//绑定的qq
	
	@GeneratedValue
	@Column(name = "rlis", nullable = false)
	private String rlis;//是否认证为学生
	
	@GeneratedValue
	@Column(name = "rltime", columnDefinition ="timestamp default CURRENT_TIMESTAMP")
	private String rltime;//实名认证时间

	

	public int getRlid() {
		return rlid;
	}

	public void setRlid(int rlid) {
		this.rlid = rlid;
	}

	public int getRluid() {
		return rluid;
	}

	public void setRluid(int rluid) {
		this.rluid = rluid;
	}

	public String getRlidcard() {
		return rlidcard;
	}

	public void setRlidcard(String rlidcard) {
		this.rlidcard = rlidcard;
	}

	public String getRlname() {
		return rlname;
	}

	public void setRlname(String rlname) {
		this.rlname = rlname;
	}

	public String getRlfileurl() {
		return rlfileurl;
	}

	public void setRlfileurl(String rlfileurl) {
		this.rlfileurl = rlfileurl;
	}

	public String getRliconurl() {
		return rliconurl;
	}

	public void setRliconurl(String rliconurl) {
		this.rliconurl = rliconurl;
	}

	public String getRladdr() {
		return rladdr;
	}

	public void setRladdr(String rladdr) {
		this.rladdr = rladdr;
	}

	public String getRlpost() {
		return rlpost;
	}

	public void setRlpost(String rlpost) {
		this.rlpost = rlpost;
	}

	public String getRlschool() {
		return rlschool;
	}

	public void setRlschool(String rlschool) {
		this.rlschool = rlschool;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getRlis() {
		return rlis;
	}

	public void setRlis(String rlis) {
		this.rlis = rlis;
	}

	public String getRltime() {
		return rltime;
	}

	public void setRltime(String rltime) {
		this.rltime = rltime;
	}
	
	
}
