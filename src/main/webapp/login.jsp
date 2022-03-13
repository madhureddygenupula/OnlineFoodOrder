<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
    body  
{  
    margin: 0;  
    padding: 0;  
   background-color:#6abadeba; 
    font-family: 'Arial';  
    background-image:url("https://cdn.pixabay.com/photo/2014/08/14/14/21/shish-kebab-417994_960_720.jpg");
    background-repeat: no-repeat, repeat;
      background-size: cover; 
}  
.login{  
        width: 382px;  
        overflow: hidden;  
        margin: auto;  
        margin: 20 0 0 450px;  
        padding: 80px;  
        border-radius: 15px ;  
          background-image: url("https://images.pexels.com/photos/326279/pexels-photo-326279.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
 background-repeat: no-repeat, repeat;
      background-size: cover; 
}  
a{
color: White;
}
div{
padding-left:360px;
margin-top:20%;
margin-left:20%;
margin-right:20%;
align-content: center;
}

#kitchen{  
    width: 300px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 10px; 
    padding-top: 6px;
    padding-bottom: 7px;
    padding-right: 9px; 
    border-radius: 20px;
  
} 
 
 
#admin{  
    width: 300px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 10px; 
    padding-top: 15px;
    padding-bottom: 7px;
    padding-right: 9px; 
    border-radius: 20px;
  
} 
 
 
#user{  
    width: 300px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 21px;  
    padding-right: 30px;
    padding-top: 6px;
    padding-bottom: 8px;
       border-radius: 20px;
} 
 
 
h2{  

    text-align: center;  
    color: white;  
    padding: 20px;  
    font-size: 30px;
} 
  
a{ 

 text-decoration: none;
 text-align: center;
 font-size: 40px;
margin-left:35%;
text-decoration:none;
text-shadow:2px 2px;
padding-bottom:30px;
    background-color: black;  
}  

</style>

</head>
<body>
 <h2>Click here to Login as</h2><br>   
<div class="login">
<a href="adminlogin.jsp" id="admin">Admin</a><br><br>
<a href="userlogin.jsp" id="user">User</a><br><br>
<a href="kitchenlogin.jsp" id="kitchen">Kitchen</a><br><br></div>
</body>
</html>