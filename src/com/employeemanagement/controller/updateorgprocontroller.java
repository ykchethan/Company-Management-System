package com.employeemanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.employeemanagement.entity.orgprofile;
import com.employeemanagement.service.updateprofservice;

/**
 * Servlet implementation class updateorgprocontroller
 */
@WebServlet("/updateorgprocontroller")
public class updateorgprocontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateorgprocontroller() {
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
		int adminid = (int)session.getAttribute("id");
		String emid = request.getParameter("empid");
		int empid = Integer.parseInt(emid);
		try {
			List<orgprofile> array8 = updateprofservice.empprof(empid);
			request.setAttribute("array8", array8);
			RequestDispatcher rs = request.getRequestDispatcher("orgprofile.jsp");
		    rs.include(request, response);
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
		int adminid = (int)session.getAttribute("id");
		
		String emid = request.getParameter("empid");
		String position = request.getParameter("pos");
		String division = request.getParameter("div");
		String managerid = request.getParameter("manid");
		
		int empid = Integer.parseInt(emid);
		//int manid = Integer.parseInt(managerid);
	      try {
	    	    List<orgprofile> array6 = updateprofservice.empprof(empid);
				request.setAttribute("array6", array6);
				
				List<orgprofile> array8 = updateprofservice.empprof(empid);
				request.setAttribute("array8", array8);
				
	    		    orgprofile getdata = updateprofservice.profupdate(empid,position,division,managerid);
	    		    request.setAttribute("sent", "Profile Updated Successfully!");
					RequestDispatcher rs = request.getRequestDispatcher("orgprofile.jsp");
				    rs.include(request, response);
			} 
	        catch (Exception e)
	        {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}


