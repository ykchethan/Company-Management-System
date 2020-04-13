package com.employeemanagement.controller;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagement.entity.logindetails;
import com.employeemanagement.service.actinactservice;

/**
 * Servlet implementation class inactivecontroller
 */
@WebServlet("/inactivecontroller")
public class inactivecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inactivecontroller() {
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
		List<logindetails> array1 = new ArrayList<logindetails>();
		List<logindetails> array2 = new ArrayList<logindetails>();
		
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
		try {
			array1 = actinactservice.inactive(id);//ask if we can remove the parameter
			request.setAttribute("array1", array1);
			
			array2 = actinactservice.manlist(id);//ask if we can remove the parameter
			request.setAttribute("array2", array2);
			
			RequestDispatcher rs = request.getRequestDispatcher("inactive.jsp");
		    rs.include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
