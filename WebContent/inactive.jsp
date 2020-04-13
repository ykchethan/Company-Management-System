<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
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
<h3>In-active users</h3>
<table>
<%if(request.getAttribute("array1")!=null){%> 
	
	<thead>
		<tr>
		<th>Id</th>
		<th>First name</th>
		<th>Last name</th>
		<th>Email id</th>
		<th>Role</th>
		<th>Manager</th>
		<th>Assign</th>
		</tr>
	</thead>
		<tbody>
			<c:if test="${not empty array1}">
				<c:forEach items="${array1}" var="data">
					<tr>
						<form name ="activate${data.id}" action="updatecontroller" method = "post">
						<td>${data.id}</td>
						<td>${data.firstname}</td>
						<td>${data.lastname}</td>
						<td>${data.emailid}</td>
						<td><select name="roleid"><option value="1">Employee</option><option value="2">Manager</option></select></td>
						<td><select name="mid"><c:if test="${not empty array2}"><c:forEach items="${array2}" var="mdata">
						<option value="${mdata.id}">${mdata.firstname}</option>
						</c:forEach></c:if>
						</select></td>
						<td><input type="hidden" name="id" value="${data.id}" /><span onclick="activate${data.id}.submit()"><button>Assign</button></span></td>
						</form>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
<%}%>
</body>
</html>