<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Status</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

<form:form action="updateorder" method="post" modelAttribute="order">

<form:input path="id" readonly="readonly"  hidden="true"/><br><br>
<form:input path="customername" readonly="readonly"  hidden="true"/><br><br>
<form:input path="username" readonly="readonly"  hidden="true"/><br><br>
<form:input path="offercost" readonly="readonly"  hidden="true"/><br><br>
<form:input path="totalcost" readonly="readonly" hidden="true"/><br><br>
Status : <select name="status" id="status"  >
  <option value="active">Active</option>
  <option value="ready">Ready</option>
  <option value="delivered">Delivered</option> 
</select>

<input type="submit" value="update status">
</form:form>
</body>
</html>