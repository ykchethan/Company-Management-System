package com.employeemanagement.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagement.dao.profileupdatedao;
import com.employeemanagement.entity.logindetails;

public class actinactservice {
	public static List<logindetails> active(String id) throws SQLException {
		int data = Integer.parseInt(id);
		List<logindetails> array2 = new ArrayList<logindetails>();
		array2= profileupdatedao.activeuser(data);
		return array2;
	}
	
	public static List<logindetails> inactive(int id1) throws SQLException {
		List<logindetails> array12 = new ArrayList<logindetails>();
		array12= profileupdatedao.inactiveuser(id1);
		return array12;
	}
	
	
	public static List<logindetails> manlist(int id) throws SQLException {
		List<logindetails> array22 = new ArrayList<logindetails>();
		array22 = profileupdatedao.manlist(id);
		return array22;
	}

	public static logindetails update(int id1, int roleid, int manid) throws SQLException{
		logindetails log = new logindetails();
		log= profileupdatedao.update(id1,roleid,manid);
		return log;
	}
}

