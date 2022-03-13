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

<%@ include file="offercredentials.jsp" %>
<%
int adminid=(Integer)(session.getAttribute("id"));
%>



<form:form action="saveoffer" method="post" modelAttribute="offer">

Code:<form:input path="code"/><br><br>
Description:<form:input path="description" rows="10" cols="10"/><br><br>
Admin Id:<form:input path="adminId" value="<%=adminid%>"/><br><br>

<input type="submit" value="submit">
</form:form>


</body>
</html>