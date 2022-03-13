<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Products</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

<h1 align="center">Add the Food Items</h1>
	<a href="cartproducts" style="float: right;margin-right: 20%;"> <button>Cart</button></a>
	<table border="1" align="center">
		<tr>

			<td>Id</td>
			<td>Name</td>
			<td>Description</td>
			<td>Cost</td>
			<td>Type</td>
			<td>FoodType</td>
			<td>Image</td>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.description }</td>
				<td>${product.cost}</td>
				<td>${product.type }</td>
				<td>${product.foodType }</td>
				<td><img alt="${product.name }" height="80px" width="80px"
					src="${product.image}"></td>
				<td><a href="addproduct?id=${product.id}">
				<input type="submit" value="add"></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>