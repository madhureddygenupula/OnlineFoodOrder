<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

<%@ include file="productcredentials.jsp" %>


<form:form action="updateproduct" method="post" modelAttribute="product">
Id:<form:input path="id"/><br><br>
Name:<form:input path="name"/><br><br>
Description:<form:input path="description" rows="10" cols="10"/><br><br>
Cost:<form:input path="cost"/><br><br>
Type:<form:input path="type"/><br><br>
FoodType:<form:input path="foodType"/><br><br>
Image Link:<form:input path="image"/><br><br>

Admin Id:<form:input path="adminId"/><br><br>
<input type="submit" value="submit">
</form:form>


</body>
</html>