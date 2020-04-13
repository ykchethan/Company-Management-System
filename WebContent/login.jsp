<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Login Page</h2>
<%if(request.getAttribute("loginerror") != null) {%>
<%= request.getAttribute("loginerror")%><%} %>
<form method="post" action="logincontroller">
	<table>
		<tr>
			<td>
				UserName: 
			</td>
			<td>
				<input type="text" name="username" placeholder="User Name">
			</td>
		</tr>
		<tr>
			<td>
				Password: 
			</td>
			<td>
				<input type="password" name="password" placeholder="Password">
			</td>
		</tr>
		<tr>
			<td>  </td>
			<td> 
				      <input type="submit" value="Sign-In">
    		</td>
		</tr>	
	</table>
</form>
</center>
</body>
</html>