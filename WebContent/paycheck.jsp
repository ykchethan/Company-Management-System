<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.sql.*,java.util.*,com.employeemanagement.entity.*"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<input type=hidden value="<%=session.getAttribute("id")%>" />
<form method="post" action="employeeback">
		    <input type="submit" value="Back" style="float: left;" width="48" height="48"/>
		</form>
	<form method="get" action="logout">
		<input type="submit" value="Log-out" style="float: right;" width="48"
			height="48" />
	</form>
	<br>
	<%salary getdata = (salary) request.getAttribute("getdata");%>
	<table>
		<tr>
			<h3>PayCheck</h3>
		</tr>
		
		
		<tr>
			<td><h4>Pay $:</h4></td>
			<td><input name="pay" type="text" value="<%=getdata.getTotal()%>"></td>
		</tr>
	</table>
</body>
</html>