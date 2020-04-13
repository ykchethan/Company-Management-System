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
<form name="registration" method="post" action="registration">
<h2>Register Here</h2>
&nbsp;
<%if(request.getAttribute("message") != null) {%>
<%= request.getAttribute("message")%><%} %>
	<table>
		<tr>
			<td>First Name :</td>
			<td><input type="text" name="firstname" placeholder="First Name"></td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td><input type="text" name="lastname" placeholder="Last Name"></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><input type="text" name="address" placeholder="address"></td>
		</tr>
		<tr>
			<td>Phone No :</td>
			<td><input type="text" name="phone" placeholder="phone no"></td>
		</tr>
		<tr>
			<td>Email Id :</td>
			<td><input type="email" name="emailid" placeholder="Email Id"></td>
		</tr>
		<tr>
			<td>User Name :</td>
			<td><input type="text" name="username" placeholder="User Name"></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><input type="password" name="password" placeholder="Password"></td>
		</tr>
		<tr>
		<td>   </td>
		<td>
				<input type="submit" value="register">
			
		</td>
		</tr>
			
	</table>
	</form>
</center>

</body>
</html>