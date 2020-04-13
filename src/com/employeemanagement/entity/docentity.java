package com.employeemanagement.entity;

import java.sql.Blob;

public class docentity {
	private int id;
	private int empid;
	private String docname;
	private Blob doc; 
	private String mimetype;
	private Boolean response;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public Blob getDoc() {
		return doc;
	}
	public void setDoc(Blob doc) {
		this.doc = doc;
	}
	public String getMimetype() {
		return mimetype;
	}
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}
	public int getDirid() {
		return dirid;
	}
	public void setDirid(int dirid) {
		this.dirid = dirid;
	}
	public Boolean getResponse() {
		return response;
	}
	public void setResponse(Boolean response) {
		this.response = response;
	}
	private int dirid;
}
