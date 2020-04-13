<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%if(request.getAttribute("fileerror") != null) {%>
<%= request.getAttribute("fileerror")%><%} %>
<% String username=(String)session.getAttribute("username"); %>

		<a href="logout"><input type="submit" value="Log-out" style="float: right;" width="48" height="48"/></a>
				<h3>Welcome, <%= request.getAttribute("firstname")%></h3>
	<form method="post" action="media" enctype="multipart/form-data">
		<input type="hidden" name="registerid" value="<%=request.getAttribute("id")%>"/>
		<input type="hidden" name="firstname" value="<%=request.getAttribute("firstname")%>"/>
		<input type="file" name="input" value="Browse"><br><br>
			<textarea name="comments" placeholder="Comments" rows="5" cols="40"></textarea><br><br>
		<input type="submit" value="Upload"/><br><br>
			<p> Files:</p>
	</form>
	
	
</body>
</html>