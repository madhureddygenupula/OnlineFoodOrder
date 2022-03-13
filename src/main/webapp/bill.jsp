<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Bill</title>
</head>
<body>
<% 
	String name=(String)session.getAttribute("name");
	if(name==null) {
		response.sendRedirect("login.jsp");
	}
	
%>


<table border="1">
  <tr>
  <td>Order For</td>
    <td>Order By</td> 
     <td>DateTime</td> 
    <td>Offer Cost</td>
    <td>Total Cost</td>
    </tr>
    <tr>
      <td>${order.getCustomername() }</td>
     <td>${order.getUsername() }</td>
     <td>${order.getDateTime() }</td>
      <td>${order.getOffercost() }</td>
       <td>${order.getTotalcost()}</td>
         </tr>
</table>

<br> <br>
<a href="saveorder">Place Order</a>

</body>


</body>
</html>