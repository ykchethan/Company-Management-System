<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(request.getAttribute("message") != null) {%>
<%= request.getAttribute("message")%><%} %>
		<form method="get" action="logout">
		    <input type="submit" value="Log-out" style="float: right;" width="48" height="48"/></a>
		</form>
<h2>Request Leaves</h2>
<form method="post" action="leavescontroller">
	<textarea name="comments" placeholder="Please mention the number of days you want to apply for leaves and the reason for leave" rows="5" cols="40"></textarea><br><br>
	<input type="submit" value="Request"/><br><br>
</form>
</body>
</html>