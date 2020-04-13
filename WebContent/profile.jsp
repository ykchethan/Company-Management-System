<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,java.util.*,com.employeemanagement.entity.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<%if(session.getAttribute("id") != null) {%>
<input type =hidden value="<%=session.getAttribute("id") %>"/> 
		<form method="get" action="logout">
		    <input type="submit" value="Log-out" style="float: right;" width="48" height="48"/></a>
		</form>
		<form method="post" action="profilecontroller">
<h2>Profile</h2>
<%logindetails getdata = (logindetails) request.getAttribute("getdata");%>
<table>
            <tr><td>First Name</td><td><input disabled="disabled" name="fname" type="text" value="<%=getdata.getFirstname()%>"></td></tr>
            <tr><td>Last Name</td><td><input disabled="disabled" name="lname" type="text" value="<%=getdata.getLastname()%>"></td></tr>
            <tr><td>Address</td><td><input type="text" name="address" value="<%=getdata.getAddress()%>"></td></tr>
            <tr><td>Phone</td><td><input type="text" name="phone" value="<%=getdata.getPhone()%>"></td></tr>
            <tr><td>Email</td><td><input type="text" name="emailid" value="<%=getdata.getEmailid()%>"></td></tr>
            <tr><td>User Name</td><td><input disabled="disabled" name="uname" type="text" value="<%=getdata.getUsername()%>"></td></tr>
            
        </table>
        
        <input type="submit" value="Update">
		</form>
</body>
<% } %>
</html>