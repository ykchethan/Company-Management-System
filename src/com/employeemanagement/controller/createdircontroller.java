package com.employeemanagement.controller;

import java.io.IOException;
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
 * Servlet implementation class createdircontroller
 */
@WebServlet("/createdircontroller")
public class createdircontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createdircontroller() {
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
		HttpSession session = request.getSession();
		int manid = (int)session.getAttribute("id");
		String direcname=request.getParameter("dirname");
		String permi=request.getParameter("perm");
		int perm=Integer.parseInt(permi);
	try
	{
		direntity data3 = dirservice.create(direcname,perm,manid);
		if(data3.getResponse()!=false)
		{	
			request.setAttribute("success", "Directory Created Successfully");
			request.setAttribute("data3", data3);
			RequestDispatcher rs = request.getRequestDispatcher("createdir.jsp");
			rs.include(request, response);
		}
		else
		{
			request.setAttribute("update error","Cannot create Directory!");
        	RequestDispatcher rs = request.getRequestDispatcher("manager.jsp");
		    rs.forward(request, response);
		
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
