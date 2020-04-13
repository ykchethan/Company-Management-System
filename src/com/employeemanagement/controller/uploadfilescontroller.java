package com.employeemanagement.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.employeemanagement.entity.docentity;
import com.employeemanagement.service.documentservice;

/**
 * Servlet implementation class uploadfilescontroller
 */
@WebServlet("/uploadfilescontroller")
@MultipartConfig(maxFileSize = 1024*1024*1024, maxRequestSize = 1024*1024*1024)
public class uploadfilescontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public uploadfilescontroller() {
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
		            docentity ddata = documentservice.upload(userid,docname,inputStream,mimetype,dirid);
		            
		            if(ddata.getResponse())
		            {
						RequestDispatcher rs = request.getRequestDispatcher("manager.jsp");
						out.println("Success!! File Uploaded");
					    rs.include(request, response);
		            }
		            else 
		            {
						RequestDispatcher rs = request.getRequestDispatcher("manager.jsp");
						out.println("File Upload UnSuccessfull!!");
					    rs.include(request, response);
		            	
		            }
			 }
			 else
			 {
					RequestDispatcher rs = request.getRequestDispatcher("manager.jsp");
					out.println("Please Attach File!!");
				    rs.include(request, response);
			 }
		
	}catch (Exception e)
		{
		
		e.printStackTrace();
		}

	}
}

