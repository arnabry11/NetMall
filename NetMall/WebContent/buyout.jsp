<%@page import="com.shopping.beans.CustBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Confirmed</title>
<%
response.setContentType("text/HTML");
String name="",cemail="";
try{
	CustBean b=(CustBean)session.getAttribute("activesess");
	 name=b.getEname();
	 cemail=b.getEemail();
	 
	 session.setAttribute("activesess", b);
}
catch(Exception e){
	System.out.println("Session Object Empty");
	e.printStackTrace();
	response.sendRedirect("custlogin.jsp");
	}


%>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div><a href="custprofile">Go Back</a></div>
<br><br><br><br><br><br>
<div class="box" align="center">Your Order Has been Successfully Placed</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>