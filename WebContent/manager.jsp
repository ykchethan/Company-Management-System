<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("id") != null) {%>
<input type =hidden value="<%=session.getAttribute("id") %>"/> 
<form method="get" action="logout">
	<input type="submit" value="Log-out" style="float: right;" width="48" height="48"/>
</form>
<h1>welcome manager</h1>
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
		 <form method="post" action="leaveget">
		 <input type="submit" value="Accept/Reject Leave">
		 </form>
	</tr>
	<tr> 
		 <form method="post" action="bonus">
		 <input type="submit" value="Bonus">
		 </form>
	</tr>
	<tr>
		 <form method="get" action="paycheck">
		  <input type="submit" value="View PayCheck">
		 </form>
	</tr>
	<tr> 
		 <form method="post" action="dircreate">
		 <input type="submit" value="Create-Directory">
		 </form>
	</tr>
	<tr> 
		 <form method="get" action="dircreate">
		 <input type="submit" value="Upload-Files">
		 </form>
	</tr>
	<tr> 
		 <form method="post" action="downloadmanfilescontroller">
		 <input type="submit" value="View/Download Files">
		 </form>
	</tr>
</table>
</body>
<% } %>
</html>