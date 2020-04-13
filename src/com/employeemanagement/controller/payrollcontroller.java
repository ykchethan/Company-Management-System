package com.employeemanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagement.entity.logindetails;
import com.employeemanagement.entity.salary;
import com.employeemanagement.service.actinactservice;
import com.employeemanagement.service.bonusservice;

/**
 * Servlet implementation class payrollcontroller
 */
@WebServlet("/payrollcontroller")
public class payrollcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payrollcontroller() {
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
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		if(session.getAttribute("id") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		String id = request.getParameter("empid");
		List<logindetails> array15 = new ArrayList<logindetails>();
		int id1 = Integer.parseInt(id);
		String data = Integer.toString(id1);
		try{
			salary regdata = bonusservice.payroll(id1);
			
			array15 = actinactservice.active(data);
			request.setAttribute("array15", array15);
			request.setAttribute("done", "Salary updated Successfully!");
			RequestDispatcher rs = request.getRequestDispatcher("active.jsp");
		    rs.include(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	}
