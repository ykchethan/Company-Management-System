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
<h3>Active users</h3>
<table>
<%if(request.getAttribute("array15")!=null){%> 
<%if(request.getAttribute("done")!= null)%>
<%= request.getAttribute("done") %>

<%if(request.getAttribute("sent")!=null)%>
 <%= request.getAttribute("sent")%>
<thead>
		<tr>
		<th>Id</th>
		<th>Firstname</th>
		<th>Lastname</th>
		<th>Emailid</th>
		<th>Role</th>
		<th>Manager</th>
		<th>Profile</th>
		<th>Run-Payroll</th>
		</tr>
	</thead>
	<tbody>
	<c:if test="${not empty array15}">
				<c:forEach items="${array15}" var="data">
				<form name ="activate${data.id}" action="updateorgprocontroller" method = "get">
					<tr>
						<td><input name="empid" type="hidden" value="${data.id}">${data.id}</td>
						<td><input name="empfname" type="hidden" value="${data.firstname}">${data.firstname}</td>
						<td><input name="emplname" type="hidden" value="${data.lastname}">${data.lastname}</td>
						<td>${data.emailid}</td>
						
						<td>${data.roleid}</td>
						<td><input name="manid" type="hidden" value="${data.managerid}">${data.managerid}</td>
						
						<td><input name="empid" type="hidden" value="${data.id}"><span onclick="activate${data.id}.submit()"><button>View</button></span></td>
					  </form>
					  
					  <td><form name ="activate${data.id}" action="payrollcontroller" method = "post"><input name="empid" type="hidden" value="${data.id}"> <input type="hidden" name="view" value="${data.id}" /><span onclick="activate${data.id}.submit()"><button>Run Payroll</button></span></td>
					  </form>
					</tr>
				</c:forEach>
	</c:if>
	</tbody>
</table>
<%}%>
</body>
</html>