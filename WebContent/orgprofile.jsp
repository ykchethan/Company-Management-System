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
<h3>Organization Profile</h3>
<%if(request.getAttribute("array8")!=null){%> 

<table>
	<c:if test="${not empty array8}">
				<c:forEach items="${array8}" var="prof">
				<form name ="activate${prof.id}" action="updateorgprocontroller" method = "post">
					<tr>
						<td>Id</td>
						<td><input name="id" type="hidden" value="${prof.id}">${prof.id}</td>
					</tr>
					<tr>
						<td>Emp-Id</td>
						<td><input name="empid" type="hidden" value="${prof.empid}">${prof.empid}</td>
					</tr>
					<tr>
						<td>Position</td>
						<td><input name="pos" type="text" value="${prof.position}"></td>
					</tr>
					<tr>
						<td>Division</td>
						<td><input name="div" type="text" value="${prof.division}"></td>
					</tr>
					<tr>
						<td>Manager-Id</td>
						<td><input name="manid" type="text" value="${prof.manager}"></td>
					</tr>
					<tr>
					  
					  <td><input name="upd" type="hidden" value="${prof.id}"><span onclick="activate${prof.id}.submit()"><button>Update Profile</button></span></td>
					  </form>
					</tr>
				</c:forEach>
	</c:if>
</table>
<%}%>
</body>
</html>