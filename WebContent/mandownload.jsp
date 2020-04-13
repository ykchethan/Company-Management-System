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
<%if(request.getAttribute("mandocs")!=null){%>
<%if(request.getAttribute("dir")!=null)%>
<% Integer id=(Integer)session.getAttribute("id"); %>
<h2>View/Download Files</h2>
<table>
<thead>
		<tr>
		<th>Id:</th>
		<th>DirId:</th>
		<th>Doc-Name:</th>
		<th>View:</th>		
		</tr>
</thead>
<tbody>
	<c:if test="${not empty mandocs}">
				<c:forEach items="${mandocs}" var="file">
				<tr>
					<form name ="activate${file.id}" action="viewdocuments" method = "get">
						<td><input type="hidden" name="dirpriid" value="${file.id}">${file.id}</td>
						<td>${file.dirid}</td>
						<td>${file.docname}</td>
						<td><input type="hidden" name="view" value="${file.id}" /><span onclick="activate${file.id}.submit()"><button>View</button></span></td>
					</form>
				</tr>
				</c:forEach>
	</c:if>
</tbody>		
</table>
<%}%>
</body>
</html>