<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quantity</title>
</head>
<body>

<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>


<form:form action="placeOrder" method="post" modelAttribute="item">

Item:<form:input path="name" readonly="readonly"/><br><br>
Cost:<form:input path="cost" readonly="readonly"/><br><br>
Enter the Quantity: <form:input path="quantity"/><br><br>
<input type="submit" value="submit">
</form:form>


</body>
</html>