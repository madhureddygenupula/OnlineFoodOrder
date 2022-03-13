<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Offer</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

<%@ include file="offercredentials.jsp" %>
<form:form action="updateoffer" method="post" modelAttribute="offers">

Id:<form:input path="id"/><br><br>
Name:<form:input path="code"/><br><br>
Description:<form:input path="description" rows="10" cols="10"/><br><br>
Admin Id:<form:input path="adminId"/><br><br>
<input type="submit" value="submit">

</form:form>


</body>
</html>