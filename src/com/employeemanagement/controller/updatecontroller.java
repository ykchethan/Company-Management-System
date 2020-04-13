package com.employeemanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class updatecontroller
 */
@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecontroller() {
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
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		int uid = (int)session.getAttribute("id");
		String id = request.getParameter("id");
		String roleid = request.getParameter("roleid");
		String manid = request.getParameter("mid");
		int id1 = Integer.parseInt(id);
		int manid1 = Integer.parseInt(manid);
		int roleid1 = Integer.parseInt(roleid);
		
		try{
			logindetails regdata = actinactservice.update(id1,roleid1,manid1);
			if(regdata.getStatus()){
			List<logindetails> array1  = actinactservice.inactive(id1);
			List<logindetails> array2 = actinactservice.manlist(id1);
			request.setAttribute("array1", array1);
			request.setAttribute("array2", array2);
			RequestDispatcher rs = request.getRequestDispatcher("inactive.jsp");
		    rs.include(request, response);
			}
			else{
				List<logindetails> array1  = actinactservice.inactive(id1);
				List<logindetails> array2 = actinactservice.manlist(id1);
				request.setAttribute("array1", array1);
				request.setAttribute("array2", array2);
				RequestDispatcher rd = request.getRequestDispatcher("inactive.jsp");
				out.println("data not saved");
				rd.include(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	}

