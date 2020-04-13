package com.employeemanagement.service;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagement.dao.profileupdatedao;
import com.employeemanagement.entity.direntity;
import com.employeemanagement.entity.docentity;

public class documentservice {

	public static docentity upload(int userid, String docname, InputStream inputStream, String mimetype, int dirid) throws SQLException {
		docentity getdata = new docentity();
		getdata= profileupdatedao.fupload(userid,docname,inputStream,mimetype,dirid);
		return getdata;
	}

	public static List<direntity> dir(int userid) throws SQLException {
		List<direntity> getdata1 = new ArrayList<direntity>();
		getdata1= profileupdatedao.getuserdir(userid);
		return getdata1;
	}

	public static docentity efileupload(int userid, String docname, InputStream inputStream, String mimetype,
			int dirid) throws SQLException {
		docentity getdata = new docentity();
		getdata= profileupdatedao.fupload(userid,docname,inputStream,mimetype,dirid);
		return getdata;
	}



}
