package com.employeemanagement.service;

import java.sql.SQLException;

import com.employeemanagement.dao.profileupdatedao;
import com.employeemanagement.entity.logindetails;

public class profileupdateservice {
	public static logindetails update(int id, String address, String phone,String emailid) throws SQLException
	{
		logindetails getdata = new logindetails();
		if(address.isEmpty())
		{
			getdata.setResponse(false);
			return getdata;
			
		}
		else if(phone.isEmpty())
		{
			getdata.setResponse(false);
			return getdata;
			
		}
		else if(emailid.isEmpty())
		{
			getdata.setResponse(false);
			return getdata;
			
		}
		else
		{
		    getdata= profileupdatedao.send(id,address,phone,emailid);
			return getdata;
		}
		
	}
}
