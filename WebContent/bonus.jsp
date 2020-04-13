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
<form method="get" action="managerback">
		    <input type="submit" value="Back" style="float: left;" width="48" height="48"/>
		</form>
		<br>
<h3>Assign Bonus</h3>
<table>
<%if(request.getAttribute("array11")!=null){%> 
	
	<thead>
		<tr>
		<th>Id</th>
		<th>Emp-Id</th>
		<th>Salary</th>
		<th>Bonus</th>
		</tr>
	</thead>
		<tbody>
			<c:if test="${not empty array11}">
				<c:forEach items="${array11}" var="data1">
					<tr>
						<form name ="activate${data1.id}" action="assignbonus" method = "post">
						<td><input type="hidden" value="${data1.id}">${data1.id}</td>
						<td><input type="hidden" name="empid" value="${data1.empid}">${data1.empid}</td>
						<td>${data1.salary}</td>
						<td><input type="number" name="bonus" min="0" value="0.0"></td>
						<td><input type="hidden" name="assignbonus" value="${data1.id}" /><span onclick="activate${data1.id}.submit()"><button>Assign Bonus</button></span></td>
						</form>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

<%}%>
</body>
</html>