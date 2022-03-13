<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Items</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

	<table border="1">
		<tr>
			<td>name</td>
			<td>quantity</td>
			<td>cost</td>		</tr>

		<c:forEach items="${items}" var="item">
			<tr>
				<td>${item.getName()}</td>
				<td>${item.getQuantity()}</td>
				<td>${item.getCost()}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>