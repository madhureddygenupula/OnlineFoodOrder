<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Product</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

<%@ include file="productcredentials.jsp" %>

<table border="1">
  <tr>
    <td>Id</td>
    <td>Name</td> 
    <td>Description</td>
    <td>Cost</td>
    <td>Type</td> 
    <td>FoodType</td>
    <td>Edit</td>
    <td>Delete</td>
    </tr>
    <c:forEach items="${products }" var="product">
<tr>
    <td>${product.id }</td>
     <td>${product.name }</td>
      <td>${product.description }</td>
       <td>${product.cost}</td>
        <td>${product.type }</td>
      <td>${product.foodType }</td>
       
        <td><a href="editproduct?id=${product.id }">Edit</a></td>
        <td><a href="deleteproduct?id=${product.id }">Delete</a></td>
         </tr>

</c:forEach>

</table>



<a href="adminhome.jsp">Back to home page</a>
</body>
</html>