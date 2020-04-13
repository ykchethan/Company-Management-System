package com.employeemanagement.entity;

public class direntity {
	private int id;
	private String dirname;
	private int manid;
	private int accessperm;
	private Boolean response;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDirname() {
		return dirname;
	}
	public void setDirname(String dirname) {
		this.dirname = dirname;
	}
	public int getManid() {
		return manid;
	}
	public void setManid(int manid) {
		this.manid = manid;
	}
	public int getAccessperm() {
		return accessperm;
	}
	public void setAccessperm(int accessperm) {
		this.accessperm = accessperm;
	}
	public Boolean getResponse() {
		return response;
	}
	public void setResponse(Boolean response) {
		this.response = response;
	}
	
}
