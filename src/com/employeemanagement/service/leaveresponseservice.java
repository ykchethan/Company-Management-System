package com.employeemanagement.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagement.dao.profileupdatedao;
import com.employeemanagement.entity.leaverequest;
import com.employeemanagement.entity.leaves;

public class leaveresponseservice {

	public static leaverequest leave(int id, int empid, int num, String response1) throws SQLException {
		leaverequest getdata = new leaverequest();
			leaves subleaves = profileupdatedao.numleaves(empid);
			int subleavesNum = subleaves.getNumofleaves();
			int finleaves = subleavesNum-num; 		
			getdata = profileupdatedao.response(id,empid,finleaves,response1);
			return getdata;
		
	}

	public static List<leaverequest> retrieve(String mid) throws SQLException {
		List<leaverequest> array4 = new ArrayList<leaverequest>();
		int data = Integer.parseInt(mid);
		    array4 = profileupdatedao.retrievedata(data);
			return array4;
		}
	}

