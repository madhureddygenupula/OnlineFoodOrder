<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<%@ include file="userhome.jsp" %>
</head>
<body>


<% 
	
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

<form:form action="updateuser" modelAttribute="myuser">

Id:<form:input path="id"/><br><br>
Name:<form:input path="name"/><br><br>
Email:<form:input path="email"/><br><br>
Password:<form:input path="password"/><br><br>
Phone:<form:input path="phone"/><br><br>
Age:<form:input path="age"/><br><br>
AdminId:<form:input path="adminId"/><br><br>
<input type="submit" value="submit">


</form:form>

</body>
</html>