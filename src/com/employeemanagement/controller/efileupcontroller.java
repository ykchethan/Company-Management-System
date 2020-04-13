package com.employeemanagement.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.employeemanagement.entity.direntity;
import com.employeemanagement.entity.docentity;
import com.employeemanagement.service.dirservice;
import com.employeemanagement.service.documentservice;

/**
 * Servlet implementation class efileupcontroller
 */
@WebServlet("/efileupcontroller")
@MultipartConfig(maxFileSize = 16567899)
public class efileupcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public efileupcontroller() {
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
			dir= dirservice.getemployeedir(empmanid);
			request.setAttribute("dir", dir);
			RequestDispatcher rs = request.getRequestDispatcher("empfileup.jsp");
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		int userid= (Integer)session.getAttribute("id");
		
		String docname = request.getParameter("docname");
		
		String dir = request.getParameter("dirid");
		int dirid = Integer.parseInt(dir);
		
		Part data = request.getPart("file");
		try{
			InputStream inputStream = null;
			 if (data.getSize() > 0) 
			 {
		            inputStream = data.getInputStream();
		            String mimetype = data.getContentType();
		            docentity ddata = documentservice.efileupload(userid,docname,inputStream,mimetype,dirid);
		            
		            if(ddata.getResponse())
		            {
						RequestDispatcher rs = request.getRequestDispatcher("empdash.jsp");
						out.println("Success!! File Uploaded");
					    rs.include(request, response);
		            }
		            else 
		            {
						RequestDispatcher rs = request.getRequestDispatcher("empdash.jsp");
						out.println("File Upload UnSuccessfull!!");
					    rs.include(request, response);
		            	
		            }
			 }
			 else
			 {
					RequestDispatcher rs = request.getRequestDispatcher("empdash.jsp");
					out.println("Please Attach File!!");
				    rs.include(request, response);
			 }
		
	}catch (Exception e)
		{
		
		e.printStackTrace();
		}
		
	}

}
