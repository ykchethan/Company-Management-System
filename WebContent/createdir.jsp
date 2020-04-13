<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<%if(request.getAttribute("success")!=null){
request.getAttribute("success");}%>
<h2>Create Directory</h2>
	<table>
		<form name ="createdir" action="createdircontroller" method = "post">
		<tr>
			<td>Directory-Name:</td>
			<td><input type="text" name="dirname"></td>
		</tr>
			<td>Permission:</td>
			<td><select name="perm"><option value="1">Default</option><option value="2">Public</option><option value="3">Private</option><option value="4">Protected</option></select></td>
		</tr>
		</tr>
			<td><input type="submit" name="dir" value="create" /></td>
		</tr>
	</table>
</body>

</html>