package com.employeemanagement.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagement.dao.profileupdatedao;
import com.employeemanagement.entity.direntity;
import com.employeemanagement.entity.salary;

public class bonusservice {

	public static salary bonus(String mid,String eid, String bon) throws SQLException {
		salary getdata1 = new salary();
		int empid = Integer.parseInt(eid);
		double bonus = Double.parseDouble(bon);
		//int empid = Integer.parseInt(eid);
		getdata1 = profileupdatedao.addbonus(empid,bonus);
		return getdata1;
	}

	public static List<salary> getbonus(int id) throws SQLException {
		List<salary> array12 = new ArrayList<salary>();
		array12= profileupdatedao.bonusret(id);
		return array12;
	}

	public static salary payroll(int id1) throws SQLException {
		salary getdata1 = new salary();
		salary getdata2 = new salary();
		getdata1 = profileupdatedao.getsal(id1);
		double sal= getdata1.getSalary();
		double bonus= getdata1.getBonus();
		double fsal = sal/12.0;
		//double updsal = sal - fsal ;
		double total = fsal + bonus;
		bonus = 0;
		getdata2 = profileupdatedao.runpay(id1, bonus, total);
		return getdata2;
	}

	public static salary paycheck(int eid) throws SQLException {
		salary getdata = new salary();
		getdata = profileupdatedao.getsal(eid);
		return getdata;
	}

}
