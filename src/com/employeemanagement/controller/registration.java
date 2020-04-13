package com.employeemanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagement.service.regdata;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
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
		// TODO Auto-generated method stub
		
		PrintWriter pw= response.getWriter();
		String fnam=request.getParameter("firstname");
	    String lnam=request.getParameter("lastname");
	    
	    String addr=request.getParameter("address");
	    String ph=request.getParameter("phone");
	    
		String emid=request.getParameter("emailid");
		String uname=request.getParameter("username");
		String pwd=request.getParameter("password");
		
		try {
			Boolean res= regdata.signin(fnam,lnam,addr,ph,emid,uname,pwd);
			if(res){
				response.sendRedirect("login.jsp");
			}else{
				RequestDispatcher reqd= request.getRequestDispatcher("registration.jsp");
				pw.println("Invalid Login Credentials");
				reqd.include(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
