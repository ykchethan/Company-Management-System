<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*,java.io.*,com.employeemanagement.entity.docentity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    docentity f = (docentity) request.getAttribute("docdata");
	Blob file = null;
	byte[] filed = null;
	String type = null;

	file = f.getDoc();
	type = f.getMimetype();
	filed = file.getBytes(1, (int) file.length());
    response.setContentType(type);
    response.setHeader("Content-Disposition", "inline");
    response.setContentLength(filed.length);
	OutputStream ostream = response.getOutputStream();
	if (type == "video/mpeg" || type == "audio/mpeg") {
        System.out.print(type);%>
	<audio controls>
    	<source src="${filed}" type="video/mpeg">
    	<source src="${filed}" type="audio/mpeg">
   		 Your browser does not support the audio element.
	</audio>

    <%}else {
    	ostream.write(filed);
    	ostream.flush();
}
%>

</body>
</html>