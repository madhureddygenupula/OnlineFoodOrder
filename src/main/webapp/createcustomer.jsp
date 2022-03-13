<%@page import="com.ty.dto.Orders"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Customer</title>
</head>
<body>
<% 
	String name=(String)session.getAttribute("name");
	if(name==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

<h1>Customer Details</h1>
<form:form action="savecustomer" method="post" modelAttribute="customer">

Name:<form:input path="name"/><br><br>
Mobile No:<form:input path="mobileno" /><br><br>
<input type="submit" value="submit">
</form:form>


</body>
</html>