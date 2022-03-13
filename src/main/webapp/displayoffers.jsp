<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Offer</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>


<table border="1">
<tr>
    <td>Id</td>
    <td>Code</td> 
    <td>Description</td>
    <td>Admin Id</td>
    <td>Edit</td>
    <td>Delete</td></tr>
    
    
    <c:forEach items="${offers}" var="offer">
<tr>
    <td>${offer.getId()}</td>
     <td>${offer.getCode()}</td>
      <td>${offer.getDescription()  }</td>
       <td>${offer.getAdminId()}</td>

        <td><a href="editoffer?id=${offer.getId()}">Edit</a></td>
        <td><a href="deleteoffer?id=${offer.getId()}">Delete</a></td>
        </tr>

</c:forEach>

</table>
<br>
<br>

<a href="adminhome.jsp">Back to home page</a>

</body>
</html>