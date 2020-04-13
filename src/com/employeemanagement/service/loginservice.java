package com.employeemanagement.service;

import java.sql.SQLException;

import com.employeemanagement.dao.regdao;
import com.employeemanagement.entity.logindetails;


public class loginservice {
	public static logindetails login(String username, String password) throws SQLException
	{
		logindetails getdata = new logindetails();
		if(username.isEmpty())
		{
			getdata.setId(0);
			return getdata;
			
		}
		else if(password.isEmpty())
		{
			getdata.setId(0);
			return getdata;
		}
		else
		{
			getdata = regdao.getRes(username,password);
			return getdata;
		}
	}

	public static logindetails logindata(int id) throws SQLException {
		// TODO Auto-generated method stub
		logindetails getdata = regdao.logindata(id);
		return getdata;
	}

	public static logindetails leaves(int id, String comm) {
		// TODO Auto-generated method stub
		return null;
	}

}
