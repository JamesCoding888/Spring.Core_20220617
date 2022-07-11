package com.spring.core.session06.entity;
import java.util.Date;
import java.util.List;
public class Emp {
	// 欄位
	private Integer eid;
	private String ename;
	private Integer age;
	private Date creattime;
	
	// 關聯關係
	private List<Job> jobs; // 一個 emp 對應 0~*個 job
	
	public Emp() {    // 建立無參建構子，避免後續會使用到無參建構子卻無法使用
		super();
	}


	public Emp(String ename, Integer age) {
		super();
		this.ename = ename;
		this.age = age;
	}


	public Integer getEid() {
		return eid;
	}


	public void setEid(Integer eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Date getCreattime() {
		return creattime;
	}


	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}


	public List<Job> getJobs() {
		return jobs;
	}


	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}


	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", age=" + age + ", creattime=" + creattime + ", jobs=" + jobs
				+ "]";
	}
	
	
}