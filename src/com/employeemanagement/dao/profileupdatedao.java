package com.employeemanagement.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagement.entity.logindetails;
import com.employeemanagement.entity.orgprofile;
import com.employeemanagement.entity.salary;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.employeemanagement.entity.direntity;
import com.employeemanagement.entity.docentity;
import com.employeemanagement.entity.leaverequest;
import com.employeemanagement.entity.leaves;

public class profileupdatedao {
	public static logindetails send(int id, String address, String phone,String emailid) throws SQLException {
		logindetails getdata= new logindetails();
		java.sql.PreparedStatement statement= getdatabaseConnection().prepareStatement("select * from registration");
		statement.close();
		java.sql.PreparedStatement statement2= getdatabaseConnection().prepareStatement("UPDATE registration set address = ?, phone = ?,emailid = ? WHERE id = ?");
		statement2.setString(1,address);
		statement2.setString(2,phone);
		statement2.setString(3,emailid);
		statement2.setInt(4, id);
		statement2.executeUpdate();
		statement2.close();
		getdata.setId(id);
		return getdata;
		
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


	public static leaverequest getleaves(int id, int manid, String comm) throws SQLException {
		leaverequest getdata= new leaverequest();
		getdata.setResponse("true");
		java.sql.PreparedStatement statement= getdatabaseConnection().prepareStatement("SELECT * from leaverequest");
		ResultSet resset= statement.executeQuery();
		int num8=1;
		while(resset.next()){
			num8++;
		}
		statement.close();
		java.sql.PreparedStatement statement2= getdatabaseConnection().prepareStatement("INSERT INTO leaverequest(id,empid,managerid,comments,response) values(?,?,?,?,?)");
		statement2.setInt(1,num8);
		statement2.setInt(2,id);
		statement2.setInt(3,manid);
		statement2.setString(4,comm);
		statement2.setString(5,"n/a");
		statement2.executeUpdate();
		statement2.close();
		return getdata;
	}
	


public static List<logindetails> activeuser(int id) throws SQLException {
		List<logindetails> getdata = new ArrayList<logindetails>();
		java.sql.PreparedStatement stmt  = getdatabaseConnection().prepareStatement("select * from registration where status = ? and roleid <> 3"); 
		stmt.setBoolean(1, true);
		ResultSet rs = stmt.executeQuery();
		 while (rs.next()) {
			 logindetails array3 = new logindetails();
			 array3.setId(rs.getInt(1));
			 array3.setFirstname(rs.getString(2));
			 array3.setLastname(rs.getString(3));
			 array3.setEmailid(rs.getString(6));
			 array3.setRoleid(rs.getInt(10));
			 array3.setManagerid(rs.getInt(11));
			 getdata.add(array3);
		 }
		 stmt.close();
		return getdata;
	}


public static List<logindetails> inactiveuser(int id1) throws SQLException {
	List<logindetails> Data = new ArrayList<logindetails>();
	java.sql.PreparedStatement stmt  = getdatabaseConnection().prepareStatement("select * from registration where status = ?"); 
	stmt.setBoolean(1, false);
	ResultSet rs = stmt.executeQuery();
	 while (rs.next()) 
	 {
	
		 logindetails array13 = new logindetails();
		 array13.setId(rs.getInt(1));
		 array13.setFirstname(rs.getString(2));
		 array13.setLastname(rs.getString(3));
		 array13.setEmailid(rs.getString(6));
		 array13.setRoleid(rs.getInt(10));
		 Data.add(array13);
	 }
	 stmt.close();
	return Data;
}

public static List<logindetails> manlist(int id) throws SQLException {
	List<logindetails> Data = new ArrayList<logindetails>();
	java.sql.PreparedStatement stmt = getdatabaseConnection().prepareStatement("select * from registration where roleid = ? and managerstatus = ?");
	stmt.setInt(1, 2);
	stmt.setBoolean(2, true);
	ResultSet resset = stmt.executeQuery();  
	while(resset.next())
	{	
		logindetails array23 = new logindetails();
		array23.setId(resset.getInt(1));
		array23.setFirstname(resset.getString(2));
		array23.setLastname(resset.getString(3));
		array23.setEmailid(resset.getString(6));
		array23.setRoleid(resset.getInt(10));
		Data.add(array23);
	 }
	stmt.close();
	return Data;
 }

public static logindetails update(int id1, int roleid, int manid) throws SQLException {
	java.sql.PreparedStatement stmt2 = getdatabaseConnection().prepareStatement("UPDATE registration SET status = ?, roleid = ?, managerid = ?, managerstatus = ? WHERE id = ?");
	stmt2.setBoolean(1, true);
	stmt2.setInt(2, roleid);
	stmt2.setInt(3, manid);
	if(roleid == 2){
		stmt2.setBoolean(4, true);
	}else{
		stmt2.setBoolean(4, false);
	}
	stmt2.setInt(5, id1);
	stmt2.executeUpdate();
	stmt2.close();
	
	
	
	java.sql.PreparedStatement stmt3 = getdatabaseConnection().prepareStatement("UPDATE registration SET managerstatus = ?, roleid = ? WHERE id = ?");
	stmt3.setBoolean(1, true);
	stmt3.setInt(2, 2);
	stmt3.setInt(3, manid);
	stmt3.executeUpdate();
	stmt3.close();
	
	java.sql.PreparedStatement stmt5 = getdatabaseConnection().prepareStatement("UPDATE salary SET manid = ? WHERE empid = ?");
	stmt5.setInt(1, manid);
	stmt5.setInt(2, id1);
	stmt5.executeUpdate();
	stmt5.close();
	
	/*from here to update org prfile*/
	java.sql.PreparedStatement stmt6 = getdatabaseConnection().prepareStatement("UPDATE orgprofile SET manager = ? WHERE empid = ?");
	String managerid=Integer.toString(manid);
	stmt6.setString(1, managerid);
	stmt6.setInt(2, id1);
	stmt6.executeUpdate();
	stmt6.close();
	
	
	/*till here to update org prfile*/
	logindetails log = new logindetails();
	log.setStatus(true);
	return log;
}

public static leaverequest response(int id, int empid,int finleaves, String response1) throws SQLException {
	leaverequest getdata= new leaverequest();
	java.sql.PreparedStatement statement= getdatabaseConnection().prepareStatement("SELECT * from leaverequest WHERE response = 'n/a'");
	statement.close();
	java.sql.PreparedStatement statement2= getdatabaseConnection().prepareStatement("UPDATE leaverequest set response = ? WHERE id = ? and empid = ?");
	statement2.setString(1,response1);
	statement2.setInt(2,id);
	statement2.setInt(3,empid);
	statement2.executeUpdate();
	statement2.close();
	
	
	java.sql.PreparedStatement statement4= getdatabaseConnection().prepareStatement("UPDATE leaves set numofleaves = ? WHERE empid = ?");
	statement4.setInt(1,finleaves);
	statement4.setInt(2,empid);
	statement4.executeUpdate();
	statement4.close();
	
	getdata.setId(empid);
	return getdata;
}

public static List<leaverequest> retrievedata(int mid) throws SQLException {
	List<leaverequest> get = new ArrayList<leaverequest>();
	java.sql.PreparedStatement stmt = getdatabaseConnection().prepareStatement("select * from leaverequest where managerid = ? and response= ?"); 
	stmt.setInt(1, mid);
	stmt.setString(2, "n/a");
	ResultSet resset = stmt.executeQuery();
	
	 while (resset.next()) 
	 {
		 leaverequest array3 = new leaverequest();
		 array3.setId(resset.getInt(1));
		 array3.setEmpid(resset.getInt(2));
		 array3.setManagerid(resset.getInt(3));
		 array3.setComments(resset.getString(4));
		 array3.setResponse(resset.getString(5));
		 get.add(array3);
	 }
	 stmt.close();
	return get;
  }

public static leaves numleaves(int empid) throws SQLException {
	leaves get = new leaves();
	java.sql.PreparedStatement stmt  = getdatabaseConnection().prepareStatement("select * from leaves where empid = ?"); 
	stmt.setInt(1, empid);
	ResultSet rs = stmt.executeQuery();
	 while (rs.next()) {
		 get.setNumofleaves(rs.getInt(2));
	 }
	 stmt.close();
	return get;
}

public static salary addbonus(int empid, double bonus) throws SQLException {
	salary getdata= new salary();
	java.sql.PreparedStatement statement= getdatabaseConnection().prepareStatement("select * from salary");
	statement.close();
	java.sql.PreparedStatement statement8= getdatabaseConnection().prepareStatement("UPDATE salary set bonus = ? WHERE empid = ?");
	statement8.setDouble(1,bonus);
	statement8.setInt(2,empid);
	statement8.executeUpdate();
	statement8.close();
	return getdata;
}

public static salary getsal(int empid) throws SQLException {
	salary get = new salary();
	java.sql.PreparedStatement stmt  = getdatabaseConnection().prepareStatement("select * from salary where empid = ?"); 
	stmt.setInt(1, empid);
	ResultSet rs = stmt.executeQuery();
	 while (rs.next()) {
		 get.setSalary(rs.getInt(4));
		 get.setBonus(rs.getInt(5));
		 get.setTotal(rs.getInt(6));
	 }
	 stmt.close();
	return get;
}

public static List<salary> bonusret(int id) throws SQLException {
	List<salary> Data = new ArrayList<salary>();
	java.sql.PreparedStatement stmt  = getdatabaseConnection().prepareStatement("select * from salary where manid = ?"); 
	stmt.setInt(1, id);
	ResultSet rs = stmt.executeQuery();
	 while (rs.next()) 
	 {
		 salary array13 = new salary();
		 array13.setId(rs.getInt(1));
		 array13.setEmpid(rs.getInt(2));
		 array13.setManid(rs.getInt(3));
		 array13.setSalary(rs.getDouble(4));
		 array13.setBonus(rs.getDouble(5));
		 array13.setTotal(rs.getDouble(6));
		 Data.add(array13);
	 }
	 stmt.close();
	return Data;
}

public static salary runpay(int id1, double bonus, double total) throws SQLException {
	salary get = new salary();
	java.sql.PreparedStatement stmt9  = getdatabaseConnection().prepareStatement("select * from salary where empid = ?"); 
	stmt9.setInt(1, id1);
	stmt9.close();
	java.sql.PreparedStatement statement10= getdatabaseConnection().prepareStatement("UPDATE salary set total = ?, bonus = ? WHERE empid = ?");
	statement10.setDouble(1, total);
	statement10.setDouble(2, bonus);
	statement10.setInt(3, id1);
	statement10.executeUpdate();
	statement10.close();
	return get;
	}

public static List<orgprofile> getprof(int empid) throws SQLException {
	List<orgprofile> Data = new ArrayList<orgprofile>();
	java.sql.PreparedStatement stmt  = getdatabaseConnection().prepareStatement("select * from orgprofile where empid = ?"); 
	stmt.setInt(1, empid);
	ResultSet rs = stmt.executeQuery();
	 while (rs.next()) 
	 {
		 orgprofile array31 = new orgprofile();
		 array31.setId(rs.getInt(1));
		 array31.setEmpid(rs.getInt(2));
		 array31.setPosition(rs.getString(3));
		 array31.setDivision(rs.getString(4));
		 array31.setManager(rs.getString(5));
		 Data.add(array31);
	 }
	 stmt.close();
	return Data;
}

public static orgprofile updprof(int empid, String position, String division, String managerid) throws SQLException {
	orgprofile get = new orgprofile();
	java.sql.PreparedStatement stmt10  = getdatabaseConnection().prepareStatement("select * from orgprofile where empid = ?"); 
	stmt10.setInt(1, empid);
	stmt10.close();
	java.sql.PreparedStatement statement11= getdatabaseConnection().prepareStatement("UPDATE orgprofile set position = ?, division = ?, manager = ? WHERE empid = ?");
	statement11.setString(1, position);
	statement11.setString(2, division);
	statement11.setString(3, managerid);
	statement11.setInt(4, empid);
	statement11.executeUpdate();
	statement11.close();
	//return get;
	
	java.sql.PreparedStatement statement12= getdatabaseConnection().prepareStatement("UPDATE salary set manid = ? WHERE empid = ?");
	int manid = Integer.parseInt(managerid);
	statement12.setInt(1, manid);
	statement12.setInt(2, empid);
	statement12.executeUpdate();
	statement12.close();
	//return get;
	
	java.sql.PreparedStatement statement13= getdatabaseConnection().prepareStatement("UPDATE registration set managerid = ? WHERE id = ?");
	//int manid = Integer.parseInt(managerid);
	statement13.setInt(1, manid);
	statement13.setInt(2, empid);
	statement13.executeUpdate();
	statement13.close();
	
	java.sql.PreparedStatement statement14= getdatabaseConnection().prepareStatement("UPDATE leaverequest set managerid = ? WHERE empid = ?");
	//int manid = Integer.parseInt(managerid);
	statement14.setInt(1, manid);
	statement14.setInt(2, empid);
	statement14.executeUpdate();
	statement14.close();
	return get;
}

public static direntity createdir(String direcname,int perm,int manid) throws SQLException {
	direntity getdata= new direntity();
	java.sql.PreparedStatement statement= getdatabaseConnection().prepareStatement("SELECT * from directory");
	ResultSet resset= statement.executeQuery();
	int num9=1;
	while(resset.next()){
		num9++;
	}
	statement.close();
	java.sql.PreparedStatement statement2= getdatabaseConnection().prepareStatement("INSERT INTO directory(id,dirname,manid,accessperm) values(?,?,?,?)");
	statement2.setInt(1,num9);
	statement2.setString(2,direcname);
	statement2.setInt(3,manid);
	statement2.setInt(4,perm);
	statement2.executeUpdate();
	statement2.close();
	getdata.setResponse(true);
	return getdata;
  }

public static List<direntity> getudir(int manid) throws SQLException {
	List<direntity> get = new ArrayList<direntity>();
	java.sql.PreparedStatement stmt6 = getdatabaseConnection().prepareStatement("select * from directory where manid = ? and accessperm <> ?"); 
	stmt6.setInt(1, manid);//get ids man id list to service
	stmt6.setInt(2, 2);
	ResultSet resset = stmt6.executeQuery();
	 while (resset.next()) 
	 {
		 direntity array6 = new direntity();
		 array6.setId(resset.getInt(1));
		 array6.setDirname(resset.getString(2));
		 array6.setManid(resset.getInt(3));
		 array6.setAccessperm(resset.getInt(4));
		 get.add(array6);
	 }
	 stmt6.close();
	return get;
}

public static logindetails getempmanid(int id) throws SQLException {
	logindetails get = new logindetails();
	java.sql.PreparedStatement stmt8 = getdatabaseConnection().prepareStatement("select * from registration where id = ?"); 
	stmt8.setInt(1, id);
	ResultSet resset = stmt8.executeQuery();
	 while (resset.next()) 
	 {
		 get.setId(resset.getInt(1));
		 get.setManagerid(resset.getInt(11));
	 }
	 stmt8.close();
	return get;
}

public static List<direntity> getdir(int manid) throws SQLException {
	List<direntity> get = new ArrayList<direntity>();
	java.sql.PreparedStatement stmt6 = getdatabaseConnection().prepareStatement("select * from directory where manid = ? and (accessperm = ? OR accessperm = ?)"); 
	stmt6.setInt(1, manid);
	stmt6.setInt(2, 1);
	stmt6.setInt(3, 4);
	ResultSet resset = stmt6.executeQuery();
	 while (resset.next()) 
	 {
		 direntity array6 = new direntity();
		 array6.setId(resset.getInt(1));
		 array6.setDirname(resset.getString(2));
		 array6.setManid(resset.getInt(3));
		 array6.setAccessperm(resset.getInt(4));
		 get.add(array6);
	 }
	 stmt6.close();
	return get;
}

public static logindetails getempmansupid(int empmanid) throws SQLException {
	logindetails get = new logindetails();
	java.sql.PreparedStatement stmt9 = getdatabaseConnection().prepareStatement("select * from registration where id = ?"); 
	stmt9.setInt(1, empmanid);
	ResultSet resset = stmt9.executeQuery();
	 while (resset.next()) 
	 {
		 get.setId(resset.getInt(1));
		 get.setManagerid(resset.getInt(11));
	 }
	 stmt9.close();
	return get;
}

public static logindetails getdownempid(int empmanid) throws SQLException {
	logindetails get6 = new logindetails();
	java.sql.PreparedStatement stmt9 = getdatabaseConnection().prepareStatement("select * from registration where managerid = ?"); 
	stmt9.setInt(1, empmanid);
	ResultSet resset = stmt9.executeQuery();
	 while (resset.next()) 
	 {
		 get6.setId(resset.getInt(1));
		 get6.setManagerid(resset.getInt(11));
	 }
	 stmt9.close();
	return get6;
}

public static List<direntity> getebelowdir(int belowmanid) throws SQLException {
	List<direntity> get3 = new ArrayList<direntity>();
	java.sql.PreparedStatement stmt6 = getdatabaseConnection().prepareStatement("select * from directory where manid = ? and accessperm <> ?"); 
	stmt6.setInt(1, belowmanid);
	stmt6.setInt(2, 2);
	ResultSet resset = stmt6.executeQuery();
	 while (resset.next()) 
	 {
		 direntity array6 = new direntity();
		 array6.setId(resset.getInt(1));
		 array6.setDirname(resset.getString(2));
		 array6.setManid(resset.getInt(3));
		 array6.setAccessperm(resset.getInt(4));
		 get3.add(array6);
	 }
	 stmt6.close();
	return get3;
}

public static List<logindetails> getallmanid(int empmanid) throws SQLException {
	List<logindetails> get = new ArrayList<logindetails>();
	java.sql.PreparedStatement stmt9 = getdatabaseConnection().prepareStatement("select * from registration where managerstatus = ?"); 
	stmt9.setBoolean(1, true);
	ResultSet resset = stmt9.executeQuery();
	 while (resset.next()) 
	 {
		 logindetails array5 = new logindetails();
		 array5.setId(resset.getInt(1));
		 array5.setManagerid(resset.getInt(11));
		 get.add(array5);
	 }
	 stmt9.close();
	return get;
}

public static List<direntity> getalldir() throws SQLException {
	List<direntity> get4 = new ArrayList<direntity>();
	java.sql.PreparedStatement stmt8 = getdatabaseConnection().prepareStatement("select * from directory where accessperm = ?"); //all public directories
	stmt8.setInt(1, 2);
	ResultSet resset = stmt8.executeQuery();
	 while (resset.next()) 
	 {
		 direntity array6 = new direntity();
		 array6.setId(resset.getInt(1));
		 array6.setDirname(resset.getString(2));
		 array6.setManid(resset.getInt(3));
		 array6.setAccessperm(resset.getInt(4));
		 get4.add(array6);
	 }
	 stmt8.close();
	return get4;
}

public static docentity fupload(int userid, String docname, InputStream inputStream, String mimetype, int dirid) throws SQLException {
	docentity getdata= new docentity();
	java.sql.PreparedStatement statement= getdatabaseConnection().prepareStatement("SELECT * from documents");
	ResultSet resset= statement.executeQuery();
	int num9=1;
	while(resset.next()){
		num9++;
	}
	statement.close();
	java.sql.PreparedStatement statement2= getdatabaseConnection().prepareStatement("INSERT INTO documents(id,empid,docname,doc,mimetype,dirid) values(?,?,?,?,?,?)");
	statement2.setInt(1,num9);
	statement2.setInt(2,userid);
	statement2.setString(3,docname);
	statement2.setBlob(4,inputStream);
	statement2.setString(5,mimetype);
	statement2.setInt(6,dirid);
	statement2.executeUpdate();
	statement2.close();
	getdata.setResponse(true);
	return getdata;
}

public static List<direntity> getuserdir(int userid) throws SQLException {
	List<direntity> get = new ArrayList<direntity>();
	java.sql.PreparedStatement stmt6 = getdatabaseConnection().prepareStatement("select * from directory where manid = ? "); 
	stmt6.setInt(1, userid);//get dir info of logged in user
	ResultSet resset = stmt6.executeQuery();
	 while (resset.next()) 
	 {
		 direntity array6 = new direntity();
		 array6.setId(resset.getInt(1));
		 array6.setDirname(resset.getString(2));
		 array6.setManid(resset.getInt(3));
		 array6.setAccessperm(resset.getInt(4));
		 get.add(array6);
	 }
	 stmt6.close();
	return get;
}

public static List<docentity> mdocs(direntity direntity) throws SQLException {
	List<docentity> get = new ArrayList<docentity>();
	java.sql.PreparedStatement stmt9 = getdatabaseConnection().prepareStatement("select * from documents where dirid = ? "); 
	stmt9.setInt(1, direntity.getId());//get dirids of the logged in manager
	ResultSet resset = stmt9.executeQuery();
	 while (resset.next()) 
	 {
		 docentity array9 = new docentity();
		 array9.setId(resset.getInt(1));
		 array9.setDocname(resset.getString(3));
		 array9.setDoc(resset.getBlob(4));
		 array9.setDirid(resset.getInt(6));
		 get.add(array9);
	 }
	 stmt9.close();
	return get;
	}

public static docentity getfileonid(int did) throws SQLException {
	docentity get = new docentity();
	java.sql.PreparedStatement stmt10 = getdatabaseConnection().prepareStatement("select * from documents where id = ? "); 
	stmt10.setInt(1, did);//get id for which it has to display 
	ResultSet resset = stmt10.executeQuery();
	 while (resset.next()) 
	 {
		 get.setId(resset.getInt(1));
		 get.setDocname(resset.getString(3));
		 get.setDoc(resset.getBlob(4));
		 get.setDirid(resset.getInt(6));
	 }
	 stmt10.close();
	return get;
}

}



