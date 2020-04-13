package com.employeemanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagement.entity.logindetails;
import com.employeemanagement.service.loginservice;

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		if(session.getAttribute("id") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String uname=request.getParameter("username");
	      String pwd=request.getParameter("password");
	      try {
	    	  	logindetails getdata = loginservice.login(uname,pwd);
				if(getdata.getId()!=0){
					HttpSession session = request.getSession();
					session.setAttribute("id", getdata.getId());
					session.setAttribute("manager", getdata.getManagerid());
					session.setAttribute("roleid", getdata.getRoleid());
					request.setAttribute("username", getdata.getUsername());
					request.setAttribute("firstname", getdata.getFirstname());
					request.setAttribute("getdata", getdata);
					if(getdata.getRoleid() == 3){
						RequestDispatcher reqd= request.getRequestDispatcher("admin.jsp");
						reqd.forward(request, response);
					}else if(getdata.getRoleid() == 2){
						RequestDispatcher reqd= request.getRequestDispatcher("manager.jsp");
						reqd.forward(request, response);
					}else{
						RequestDispatcher reqd= request.getRequestDispatcher("empdash.jsp");//employee
						reqd.forward(request, response);
					}
				}else{
					request.setAttribute("loginerror","Please fill all the fields");
		        	RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
				    rs.forward(request, response);
				
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

