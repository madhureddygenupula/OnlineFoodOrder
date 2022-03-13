<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Cart</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

	<table border="1">
		<tr>

			<td>Name</td>
			<td>Cost</td>
			<td>Quantity</td>
		</tr>
		<c:forEach items="${myItems}" var="item">
			<tr>
				<td>${item.name}</td>
				<td>${item.cost}</td>
				<td>${item.quantity }</td>
			</tr>
		</c:forEach>
		
	</table>
	<br><br>
	<form action="availoffer">
	Enter Coupon Code to avail Offer: <input type="text" name="code">	<br><br>
	<input type="submit" value="Place Order">
	
	</form>
</body>
</html>