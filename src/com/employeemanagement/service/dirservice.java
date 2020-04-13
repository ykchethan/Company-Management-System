package com.employeemanagement.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagement.dao.profileupdatedao;
import com.employeemanagement.entity.direntity;
import com.employeemanagement.entity.docentity;
import com.employeemanagement.entity.logindetails;

public class dirservice {

	public static direntity create(String direcname,int perm,int manid) throws SQLException {
		direntity data14 = profileupdatedao.createdir(direcname,perm,manid);
			return data14;
	}

	public static List<direntity> getdir(int empmanid) throws SQLException {
		ArrayList<direntity> manager_ids=new  ArrayList<direntity>();
	
		//2
		//id of all managers below
		int bmanid = empmanid;
		int belowmanid = 0;
		List<Integer> lowman = new ArrayList<Integer>();
		while(belowmanid!=bmanid)
		{
		logindetails downempdata = profileupdatedao.getdownempid(bmanid);
		bmanid = downempdata.getId();
		lowman.add(bmanid);
		}
		
		for(int j=0;j<lowman.size();j++)
		{
			int bm = lowman.get(j);
			List<direntity> array4= profileupdatedao.getebelowdir(bm);
			manager_ids.addAll(array4);
		}
		//this is dir of emp of all emp below
		//List<direntity> databelowman = new ArrayList<direntity>();
		//databelowman= profileupdatedao.getebelowdir(belowmanid);//still yet to add to list
				
		
		
        
        
        //getting supermanger ids
		int supermanagerid= empmanid;
		int newmanid=2;
		List<Integer> man = new ArrayList<Integer>();
		while(newmanid!=supermanagerid)
		{
			logindetails manager = profileupdatedao.getempmansupid(supermanagerid);
			supermanagerid = manager.getManagerid();
			man.add(supermanagerid);
			
		}
		//getting supermanager default and protected directories
		for(int i=0;i<man.size();i++)
		{
			int supaman= man.get(i);
			List<direntity> array3 = profileupdatedao.getdir(supaman);
			manager_ids.addAll(array3);
		}
		
		
		//getting present logged in managers directories
		List<direntity> dataempman = new ArrayList<direntity>();
		dataempman= profileupdatedao.getudir(empmanid); //DONE
		manager_ids.addAll(dataempman);
		
		//all public directories with public access
		List<direntity> dataallman = new ArrayList<direntity>(); //DONE
		dataallman= profileupdatedao.getalldir();
		manager_ids.addAll(dataallman);
		
		
		//manager_ids.addAll(databelowman);
        return manager_ids;//return manager_ids;
	}

	public static List<direntity> getempdir(int id) throws SQLException {
		logindetails empdata = new logindetails();
		empdata = profileupdatedao.getempmanid(id);
		int manid = empdata.getManagerid();
		
		List<direntity> data16 = new ArrayList<direntity>();
		data16= profileupdatedao.getdir(manid);
		return data16;
		
	}

	public static List<docentity> getmandocs(List<direntity> dir) throws SQLException {
		List<docentity> alldata = new ArrayList<docentity>();
		List<docentity> docsman = new ArrayList<docentity>();
		for(int i=0;i<dir.size();i++)
		{
			docsman = profileupdatedao.mdocs(dir.get(i));
			alldata.addAll(docsman);
		}
		return alldata;
	}

	public static docentity getdocument(int did) throws SQLException 
	{
		docentity docs = new docentity();
		docs = profileupdatedao.getfileonid(did);
		return docs;
	}

	public static List<direntity> getemployeedir(int empmanid) throws SQLException {
		ArrayList<direntity> manager_ids=new  ArrayList<direntity>();
		
		List<direntity> dataallman = new ArrayList<direntity>(); //DONE
		dataallman= profileupdatedao.getalldir();
		manager_ids.addAll(dataallman);//all public
		
		//view all super man default and private directories
		int supermanagerid= empmanid;
		int newmanid=2;
		List<Integer> man = new ArrayList<Integer>();
		while(newmanid!=supermanagerid)
		{
			logindetails manager = profileupdatedao.getempmansupid(supermanagerid);
			supermanagerid = manager.getManagerid();
			man.add(supermanagerid);
			
		}
		//getting supermanager default and protected directories
		for(int i=0;i<man.size();i++)
		{
			int supaman= man.get(i);
			List<direntity> array3 = profileupdatedao.getdir(supaman);
			manager_ids.addAll(array3);
		}
		return manager_ids;
	}

}
