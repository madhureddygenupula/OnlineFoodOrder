<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
<style>
 body  
{  
background-image:url("https://livewallpaperhd.com/wp-content/uploads/2020/09/Food-Background-Wallpaper-HD.jpg");
    background-repeat: no-repeat, repeat;
      background-size: cover;
    margin: 0;  
    padding: 0;  
    background-color:#6abadeba;  
    font-family: 'Arial';  
}  
.admin{  
        width: 382px;  
        overflow: hidden;  
        margin: auto;  
        margin-top:10%;
        margin: 20 0 0 450px;  
        padding: 50px;  
        background-color:white;
        border-radius: 15px ;  
          
}  

</style>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

<%@include file="adminhome.jsp" %>

<%
int adminid=(Integer)(session.getAttribute("id"));
%>
<div class="admin">
<form:form action="saveuser" modelAttribute="user">

Name:<form:input path="name"/><br><br>
Email:<form:input path="email"/><br><br>
Password:<form:input path="password"/><br><br>
Phone:<form:input path="phone"/><br><br>
Age:<form:input path="age"/><br><br>

Admin Id:<form:input path="adminId" value="<%=adminid%>"/><br><br>
<input type="submit" value="submit">


</form:form>
</div>
</body>
</html>