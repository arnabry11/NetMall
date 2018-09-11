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
<div align="right" style="position: relative;"> <a href="logout" >Logout</a> </div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div align="center">
<form action="viewitem11.jsp?sid=<%=sid%>">
<input type="text" name="id" placeholder="Enter The Item ID"><input type="submit" value="Enter"><p></p>
</form>
</div>
</body>
</html>