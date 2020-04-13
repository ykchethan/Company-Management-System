package com.employeemanagement.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagement.dao.profileupdatedao;
import com.employeemanagement.entity.orgprofile;

public class updateprofservice {

	public static List<orgprofile> empprof(int empid) throws SQLException {
		List<orgprofile> array4 = new ArrayList<orgprofile>();
		array4 = profileupdatedao.getprof(empid);
		return array4;
	}

	public static orgprofile profupdate(int empid, String position, String division, String managerid) throws SQLException {
		orgprofile array5 = new orgprofile();
		array5 = profileupdatedao.updprof(empid,position,division,managerid);
		return array5;
	}
}

