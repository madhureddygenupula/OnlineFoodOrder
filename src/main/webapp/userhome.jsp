<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
<style>
body{
background-image:url("https://cdn.pixabay.com/photo/2014/08/14/14/21/shish-kebab-417994_960_720.jpg");
    background-repeat: no-repeat, repeat;
      background-size: cover;}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

li {
  display: inline;
}
</style>
<title>User Home</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

<ul style="background-color: bisque; font-size: 36px">
  <li style="float: left;"><a href="vieworderproducts">Create Order</a></li>
   <li style=" margin-left: 25%"><a href="vieworder">Display Order</a></li>
   <li style="float: right;"><a href="userlogout">Logout</a></li>
</ul>

</body>
</html>