package com.employeemanagement.service;

import java.sql.SQLException;

import com.employeemanagement.dao.regdao;

public class regdata {

	public static Boolean signin(String firstname, String lastname, String address, String phone,String emailid, String username, String password) throws SQLException
	{
		if(firstname.isEmpty())
		{
			return false;
			
		}
		else if(lastname.isEmpty())
		{
			return false;
			
		}
		else if(address.isEmpty())
		{
			return false;
			
		}
		else if(phone.isEmpty())
		{
			return false;
			
		}
		else if(emailid.isEmpty())
		{
			return false;
			
		}
		else if(username.isEmpty())
		{
			return false;
			
		}
		else if(password.isEmpty())
		{
			return false;
			
		}
		else
		{
			Boolean result= regdao.send(firstname,lastname,address,phone,emailid,username,password);
			return result;
		}
		
	}
}
