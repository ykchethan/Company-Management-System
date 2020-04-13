package com.employeemanagement.service;

import java.sql.SQLException;

import com.employeemanagement.dao.profileupdatedao;
import com.employeemanagement.entity.leaverequest;

public class leaveservice {

	public static leaverequest leaves(int id,int manid, String comm) throws SQLException {
		leaverequest getdata = new leaverequest();
		
		if(comm.isEmpty())
		{
			getdata.setId(0);
			return getdata;
		}
		else
		{
			getdata = profileupdatedao.getleaves(id,manid,comm);
			return getdata;
		}
	}

}
