<%@page import="com.shopping.beans.SellerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
response.setContentType("text/HTML");
String name="",sid="";

try{
SellerBean sb=(SellerBean)session.getAttribute("activesess");

	 name=sb.getEname();
	 sid=sb.getEid();
	session.setAttribute("activesess", sb);
}
catch(Exception e){
	System.out.println("Session Object Empty");
	e.printStackTrace();
	response.sendRedirect("sellerlogin.jsp");
}

%>

</head>
<body>

Seller ID = <%=sid %><br><br>
<div align="right" style="position: relative;"> <a href="logout" >Logout</a> </div>

<div align="center"> 


<h1 align="center" style="font-size: x-large; color: orange;">ITEM UPDATE</h1>
<form action="updateitem?sid=<%=sid %>" method="post">
<table align="center">


<tr>
	<td>Enter Item id</td>
	<td><input type="text" name="id" placeholder="Item Id"></td>
</tr>


<tr>
	<td style="font-size: 20px;font-style: oblique;color: red;">Enter Name</td>
	<td><input type="text" name="name" placeholder="Name"></td>
</tr>

<tr>
	<td>Enter Price</td>
	<td><input type="text" name="price" placeholder="Price"></td>
</tr>



<tr>
	<td>Enter Item Description</td>
	<td><input type="text" name="details"placeholder="Item Description"></td>
</tr>

<tr>
	<td>Enter Item Stock</td>
	<td><input type="text" name="stock"placeholder="Item Stock"></td>
</tr>




<tr>
	
	<td colspan="2" align="center"><input type="submit" name="sub1" value="Submit"></td>
</tr>

</table>
</form>



 </div>

</body>
<% %>
</html>