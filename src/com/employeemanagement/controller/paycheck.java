package com.employeemanagement.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.employeemanagement.entity.direntity;
import com.employeemanagement.entity.salary;
import com.employeemanagement.service.bonusservice;
import com.employeemanagement.service.dirservice;

/**
 * Servlet implementation class paycheck
 */
@WebServlet("/paycheck")
public class paycheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paycheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int eid = (int)session.getAttribute("id");
		try {
			salary getdata = bonusservice.paycheck(eid);
			RequestDispatcher rs = request.getRequestDispatcher("manpaycheck.jsp");
			request.setAttribute("getdata",getdata);
			rs.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int eid = (int)session.getAttribute("id");
		try {
			salary getdata = bonusservice.paycheck(eid);
			RequestDispatcher rs = request.getRequestDispatcher("paycheck.jsp");
			request.setAttribute("getdata",getdata);
			rs.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
