<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("id") == null) {
response.sendRedirect(request.getContextPath() + "/login.jsp");
return;}%>
<%if(session.getAttribute("id") != null) {%>

<input type =hidden value="<%=session.getAttribute("id") %>"/> 
<form method="get" action="logout">
		    <input type="submit" value="Log-out" style="float: right;" width="48" height="48"/>
		</form>
<h1>Welcome </h1>
<table>
	<tr>
		<form method="get" action="profileupdatecontroller">
		 <input type="submit" value="Profile">
		 </form>
    </tr>
    <tr>
		 <form method="post" action="profileupdatecontroller">
		  <input type="submit" value="Request Leaves">
		 </form>
	</tr>
	<tr>
		 <form method="get" action="efileupcontroller">
		  <input type="submit" value="Upload-Files">
		 </form>
	</tr>
	<tr>
		 <form method="post" action="efdownloadcontroller">
		  <input type="submit" value="View/Download-Files">
		 </form>
	</tr>
	<tr>
		 <form method="post" action="paycheck">
		  <input type="submit" value="View PayCheck">
		 </form>
	</tr>
</table>

</body>
<% } %>
</html>