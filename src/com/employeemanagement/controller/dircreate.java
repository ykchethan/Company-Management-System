package com.employeemanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagement.entity.direntity;
import com.employeemanagement.service.dirservice;

/**
 * Servlet implementation class dircreate
 */
@WebServlet("/dircreate")
public class dircreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dircreate() {
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
		int empmanid = (int)session.getAttribute("id");
		List<direntity> dir= new ArrayList<direntity>();
		try {
			dir= dirservice.getdir(empmanid);
			request.setAttribute("dir", dir);
			RequestDispatcher rs = request.getRequestDispatcher("uploadfiles.jsp");
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
		int manid = (int)session.getAttribute("id");
		RequestDispatcher rs = request.getRequestDispatcher("createdir.jsp");
		rs.include(request, response);
	}

}
