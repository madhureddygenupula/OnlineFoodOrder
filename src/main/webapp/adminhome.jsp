<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

li {
  display: inline;
}
body{
background-image:url("https://www.itl.cat/pngfile/big/285-2853509_food-wallpaper-hd-high-resolution-food-images-hd.jpg");
    background-repeat: no-repeat, repeat;
      background-size: cover;}
      
  a{
  color: white;
  }    
</style>
<title>Admin Home</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>


<ul style="font-size: 43px; color:white;">
  <li style="float: left;"><a href="usercredentials.jsp">User</a></li>
  
   <li style=" margin-left: 20%"><a href="offercredentials.jsp">Offer</a></li>
  
   <li style=" margin-left: 20%"><a href="productcredentials.jsp">Product</a></li>
   <li style="float: right"><a href="adminlogout">Logout</a></li>
</ul>

</body>
</html>