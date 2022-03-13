<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Product</title>
</head>
<body>

	<%
	if ((String) session.getAttribute("name") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<%@ include file="productcredentials.jsp"%>
	<%
	int adminid = (Integer) (session.getAttribute("id"));
	%>



	<form:form action="saveproduct" method="post" modelAttribute="product">

Name:<form:input path="name" />
		<br>
		<br>
Description:<form:input path="description" rows="10" cols="10" />
		<br>
		<br>
Cost:<form:input path="cost" />
		<br>
		<br>
Type:<select name="type" id="type">
			<option value="veg">Veg</option>
			<option value="non-veg">non-veg</option>
			<option value="veg&non-veg">veg&non-veg</option>
		</select><br></br>
FoodType:<select name="foodType" id="foodType">
			<option value="single">single</option>
			<option value="combo">combo</option>
			<option value="meal">meal</option>

		</select><br></br>
Admin Id:<form:input path="adminId" value="<%=adminid%>" />
		<br>
		<br>
Image Link:<form:input path="image" />

		<input type="submit" value="Done">

	</form:form>

</body>
</html>