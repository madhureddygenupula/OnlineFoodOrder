<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Credentials</title>
</head>

<body>

<%
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
%>

<%@ include file="adminhome.jsp"%>

<ul style="background-color: blue;margin-top:6px; font-size: 39px;color: white;">
  <li style="float: left"><a href="createuser" style="text-decoration: none">Create User</a></li>
  
   <li style=" margin-left: 40%"><a href="viewusers" style="text-decoration: none">Display User</a></li>
</ul>

<br>


</body>
</html>