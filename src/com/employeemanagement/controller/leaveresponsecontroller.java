package com.employeemanagement.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagement.entity.leaverequest;
import com.employeemanagement.service.leaveresponseservice;

/**
 * Servlet implementation class leaveresponsecontroller
 */
@WebServlet("/leaveresponsecontroller")
public class leaveresponsecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public leaveresponsecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("id") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id1 = request.getParameter("id");
		String emid = request.getParameter("empid");
		String number = request.getParameter("number");
		String response1 = request.getParameter("response");
		int id = Integer.parseInt(id1);
		int empid = Integer.parseInt(emid);
		int num = Integer.parseInt(number);
	      try {
	    	  	leaverequest getdata = leaveresponseservice.leave(id,empid,num,response1);
				if(getdata.getId()!=0)
				{
					RequestDispatcher rs = request.getRequestDispatcher("manager.jsp");
				    rs.include(request, response);
				}
			} 
	        catch (Exception e)
	        {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
