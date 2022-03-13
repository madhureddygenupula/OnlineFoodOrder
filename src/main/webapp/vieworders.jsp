<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">  
<title>View Orders</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

	<table border="1">
		<tr>
			<td>Id</td>
			<td>By</td>
			<td>For</td>
			<td>Total cost</td>
			<td>Status</td>
			<td>Edit</td>
			<td>View Items</td>
		</tr>

		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.getId()}</td>
				<td>${order.getUsername()}</td>
				<td>${order.getCustomername()}</td>
				<td>${order.getTotalcost()}</td>
				<td>${order.getStatus()}</td>


				<td><a href="editorder?id=${order.getId()}">Update</a></td>
				<td><a href="getItems?id=${order.getId()}">View Item</a></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>