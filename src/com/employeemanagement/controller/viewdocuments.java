package com.employeemanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagement.entity.docentity;
import com.employeemanagement.service.dirservice;

/**
 * Servlet implementation class viewdocuments
 */
@WebServlet("/viewdocuments")
public class viewdocuments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewdocuments() {
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
		
		String view = request.getParameter("view");
		String documentid = request.getParameter("dirpriid");
		int did = Integer.parseInt(documentid); 
		try
		{
			    docentity docdata = dirservice.getdocument(did);
			    request.setAttribute("docdata", docdata);
				RequestDispatcher rs = request.getRequestDispatcher("filedown.jsp");
			    rs.forward(request, response);
			
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
