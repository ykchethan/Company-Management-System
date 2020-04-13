package com.employeemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employeemanagement.entity.logindetails;

public class regdao {
	public static Boolean send(String firstname, String lastname, String address, String phone,String emailid, String username, String password) throws SQLException {
		java.sql.PreparedStatement statement= getdatabaseConnection().prepareStatement("select * from registration");
		ResultSet resset= statement.executeQuery();
		int num=1;
		while(resset.next()){
			num++;
		}
		statement.close();
		java.sql.PreparedStatement statement2= getdatabaseConnection().prepareStatement("INSERT INTO registration(id,firstname,lastname,address,phone,emailid,username,password,status,roleid,managerid,managerstatus) values(?,?,?,?,?,?,?,?,?,?,?,?)");
		statement2.setInt(1,num);
		statement2.setString(2,firstname);
		statement2.setString(3,lastname);
		statement2.setString(4,address);
		statement2.setString(5,phone);
		statement2.setString(6,emailid);
		statement2.setString(7,username);
		statement2.setString(8,password);
		statement2.setBoolean(9,false);
		statement2.setInt(10,1);
		statement2.setInt(11,0);
		statement2.setBoolean(12,false);
		statement2.executeUpdate();
		statement2.close();
		/*Till here for inserting into registration table*/
		
		java.sql.PreparedStatement statement3= getdatabaseConnection().prepareStatement("select * from leaves");
		ResultSet resset1= statement3.executeQuery();
		int num1=1;
		while(resset1.next()){
			num1++;
		}
		statement3.close();
		java.sql.PreparedStatement statement4= getdatabaseConnection().prepareStatement("INSERT INTO leaves(id,numofleaves,empid) values(?,?,?)");
		statement4.setInt(1,num1);
		statement4.setInt(2,4);
		statement4.setInt(3,num);
		statement4.executeUpdate();
		statement4.close();
		/*Till here for inserting into leaves table*/
		
		
		java.sql.PreparedStatement statement5= getdatabaseConnection().prepareStatement("select * from salary");
		ResultSet resset2= statement5.executeQuery();
		int num2=1;
		while(resset2.next()){
			num2++;
		}
		statement5.close();
		java.sql.PreparedStatement statement6= getdatabaseConnection().prepareStatement("INSERT INTO salary(id,empid,manid,salary,bonus,total) values(?,?,?,?,?,?)");
		statement6.setInt(1,num2);
		statement6.setInt(2,num);
		statement6.setInt(3, 0);
		statement6.setDouble(4,80000);
		statement6.setDouble(5,0);
		statement6.setDouble(6,0);
		statement6.executeUpdate();
		statement6.close();
		/*Till here for inserting into salary table*/
		
		
		java.sql.PreparedStatement statement7= getdatabaseConnection().prepareStatement("select * from orgprofile");
		ResultSet resset3= statement7.executeQuery();
		int num3=1;
		while(resset3.next()){
			num3++;
		}
		statement7.close();
		java.sql.PreparedStatement statement8= getdatabaseConnection().prepareStatement("INSERT INTO orgprofile(id,empid,position,division,manager) values(?,?,?,?,?)");
		statement8.setInt(1,num3);
		statement8.setInt(2,num);
		statement8.setString(3,"n/a");
		statement8.setString(4,"n/a");
		statement8.setString(5,"n/a");
		statement8.executeUpdate();
		statement8.close();
		/*Till here for inserting into orgprofile table*/
		return true;
	}
	static Connection connect=null;
	private static Connection getdatabaseConnection() throws SQLException {
		if(connect != null) return connect;
		String url= "jdbc:mysql://localhost:3306/employeemanagement";
		String username="root";
		String password="root";
		return getdatabaseConnection(url,username,password);
		}

	private static Connection getdatabaseConnection(String databasename,String username,String password)
    {
		Connection connect = null;
        try
        {
        	
            Class.forName("com.mysql.jdbc.Driver");
           
            connect=DriverManager.getConnection(databasename, username, password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return connect;        
    }

	/*Till here for registration*/
	
	
public static logindetails getRes(String username, String password) throws SQLException {
		      // int uname = Integer.parseInt(username);
	logindetails data = new logindetails();
			   PreparedStatement pst = getdatabaseConnection().prepareStatement("Select * from registration where username= ? and password= ?");
			   pst.setString(1, username); 
		       pst.setString(2, password);
		       ResultSet resset = pst.executeQuery();  
		       while(resset.next()){
		    	   data.setId(resset.getInt(1));
		    	   data.setFirstname(resset.getString(2));
		    	   data.setLastname(resset.getString(3));
		    	   data.setAddress(resset.getString(4));
		    	   data.setPhone(resset.getString(5));
		    	   data.setEmailid(resset.getString(6));
		    	   data.setUsername(resset.getString(7));
		    	   data.setPassword(resset.getString(8));
		    	   data.setStatus(resset.getBoolean(9));
		    	   data.setRoleid(resset.getInt(10));
		    	   data.setManagerid(resset.getInt(11));
		    	   data.setManagerstatus(resset.getBoolean(12));


		    	   pst.close();
		    	   return data;
		    	   
		       }
		       pst.close();
		       data.setStatus(false);
		       return data;
		       
		       

}

public static logindetails logindata(int id) throws SQLException {
	// TODO Auto-generated method stub
	logindetails data = new logindetails();
	   PreparedStatement pst = getdatabaseConnection().prepareStatement("Select * from registration where id = ?");
	   pst.setInt(1, id);
    ResultSet resset = pst.executeQuery();  
    while(resset.next()){
 	   data.setId(resset.getInt(1));
 	   data.setFirstname(resset.getString(2));
 	   data.setLastname(resset.getString(3));
 	   data.setAddress(resset.getString(4));
 	   data.setPhone(resset.getString(5));
 	   data.setEmailid(resset.getString(6));
 	   data.setUsername(resset.getString(7));
 	   data.setPassword(resset.getString(8));
 	   data.setStatus(resset.getBoolean(9));
 	   data.setRoleid(resset.getInt(10));
 	   data.setManagerid(resset.getInt(11));
 	   data.setManagerstatus(resset.getBoolean(12));
 	   pst.close();
 	   return data;
 	   
    }
    pst.close();
    data.setStatus(false);
    return data;
	}



}
