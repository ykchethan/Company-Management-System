package com.employeemanagement.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagement.entity.logindetails;
import com.employeemanagement.service.profileupdateservice;

/**
 * Servlet implementation class profilecontroller
 */
@WebServlet("/profilecontroller")
public class profilecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletResponse response;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profilecontroller() {
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
		int id = (int)session.getAttribute("id");
		int roleid = (int)session.getAttribute("roleid");
      String addr=request.getParameter("address");
      String phn=request.getParameter("phone");
      String eid=request.getParameter("emailid");
      try {
			logindetails getdata = profileupdateservice.update(id,addr,phn,eid);
			if(getdata.getId()!=0)
			{
				request.setAttribute("id", getdata.getId());
				request.setAttribute("addr", getdata.getAddress());
				request.setAttribute("phn", getdata.getPhone());
				request.setAttribute("eid", getdata.getEmailid());
				if(roleid== 3)
				{
					RequestDispatcher reqd= request.getRequestDispatcher("admin.jsp");
					reqd.forward(request, response);
				}
				else if(roleid== 2)
				{
					RequestDispatcher reqd= request.getRequestDispatcher("manager.jsp");
					reqd.forward(request, response);
				}
				else
				{
					RequestDispatcher reqd= request.getRequestDispatcher("empdash.jsp");
					reqd.forward(request, response);
				}
			}else{
				request.setAttribute("update error","Please fill all the fields");
	        	RequestDispatcher rs = request.getRequestDispatcher("profile.jsp");
			    rs.forward(request, response);
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
