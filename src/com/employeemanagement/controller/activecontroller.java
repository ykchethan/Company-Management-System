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
import com.employeemanagement.service.actinactservice;

/**
 * Servlet implementation class activecontroller
 */
@WebServlet("/activecontroller")
public class activecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public activecontroller() {
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
		List<logindetails> array15 = new ArrayList<logindetails>();
		List<logindetails> array1 = new ArrayList<logindetails>();
		List<logindetails> array2 = new ArrayList<logindetails>();
		try 
		{
			HttpSession session= request.getSession();
			int id = (int)session.getAttribute("id");
			String data = Integer.toString(id);
			
			array15 = actinactservice.active(data);
			request.setAttribute("array15", array15);
			
			array1 = actinactservice.inactive(id);
			request.setAttribute("array1", array1);
			
			array2 = actinactservice.manlist(id);
			request.setAttribute("array2", array2);
			
			RequestDispatcher rs = request.getRequestDispatcher("active.jsp");
		    rs.include(request, response);
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
