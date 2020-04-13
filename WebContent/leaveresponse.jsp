<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.employeemanagement.entity.leaverequest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="logout">
		    <input type="submit" value="Log-out" style="float: right;" width="48" height="48"/>
		</form>
<form method="get" action="managerback">
		    <input type="submit" value="Back" style="float: left;" width="48" height="48"/>
		</form>
		<br>
<h1>Leave Response Page</h1>
<table>
<%if(request.getAttribute("array5")!=null){%> 
	<thead>
		<tr>
		<th>Id</th>
		<th>EmployeeId</th>
		<th>Comments</th>
		<th>Number of Leaves</th>
		<th>Response</th>
		<th>Submit</th>
		</tr>
	</thead>
		<tbody>
			<c:if test="${not empty array5}">
				<c:forEach items="${array5}" var="data">
					<tr>
					<form name="activate${data.id}" action="leaveresponsecontroller" method= "post">
						<td>${data.id}</td>
						<td><input type="hidden" name="empid" value="${data.empid}">${data.empid}</td>
						<td>${data.comments}</td>
						<td><input type="number" name="number" min="0" max="4" value="0"></td>
						<td><select name="response"><option value="accepted">Accept</option><option value="declined">Decline</option></select></td>
						<td><input type="hidden" name="id" value="${data.id}" /><span onclick="activate${data.id}.submit()"><button>Update</button></span></td>
					</form>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<%}%>
</body>
</html>