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
<%if(request.getAttribute("dir")!=null){%> 
<% Integer id=(Integer)session.getAttribute("id"); %>
<h2>Upload Files</h2>
<table>
  <form name ="upload" action="efileupcontroller" enctype="multipart/form-data" method = "post">
	<tr>
		<td>Document Name</td>
		<td><input type="text" name="docname"></td>
	</tr>
	<tr>
		<td>File:</td>
		<td><input type="file" name="file" value="Browse"></td>
	</tr>
	<tr>
		<td>Directory Id:</td>
		<td><select name="dirid"><c:if test="${not empty dir}">
									<c:forEach items="${dir}" var="data">
										<option value="${data.id}">${data.dirname}</option>
									</c:forEach>
								   </c:if>
			</select>
		</td>
	</tr>
	<tr>
		<td><input type="submit" name="uploadfiles" value="Upload"></td>
	</tr>
</table>
<%}%>
</body>
</html>