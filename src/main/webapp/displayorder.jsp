<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	if((String)session.getAttribute("name")==null) {
		response.sendRedirect("login.jsp");
	}
	
%>

<table border="1">
  <tr>
    <td>By</td> 
    <td>Offer Cost</td>
    <td>Total Cost</td>
    <td>DateTime</td> 
    <td>View Items</td>
    
    </tr>
    <c:forEach items="${orders }" var="order">
<tr>
     <td>${order.getUsername() }</td>
      <td>${order.getOffercost() }</td>
       <td>${order.getTotalcost()}</td>
        <td>${order.getDateTime() }</td>
       
         </tr>

</c:forEach>

</table>

<br> <br>
<a href="createcustomer">Place Order</a>

</body>
</html>