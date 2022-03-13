<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display User</title>

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
        width: 60%;  
        overflow: hidden;  
        margin: auto;  
        margin-top:10%;
        
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
<div class="admin">
<table border="1">
<tr>
    <td>Id</td>
    <td>Name</td> 
    <td>Email</td>
    <td>Password</td>
    <td>Phone</td>
    <td>age</td> 
    <td>Edit</td>
    <td>Delete</td>
    
    </tr>
    <c:forEach items="${users }" var="user">
<tr>
    <td>${user.id }</td>
     <td>${user.name }</td>
      <td>${user.email }</td>
       <td>${user.password}</td>
        <td>${user.phone }</td>
      <td>${user.age }</td>
       
       
        <td><a href="edituser?id=${user.id }">Edit</a></td>
        <td><a href="deleteuser?id=${user.id }">Delete</a></td>
        </tr>

</c:forEach>

</table>
<a href="adminhome.jsp">Back to home page</a>
</div>
</body>
</html>