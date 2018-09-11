<%@page import="java.sql.ResultSet"%>
<%@page import="com.shopping.doau.mydoau"%>
<%@page import="com.shopping.beans.CustBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%

response.setContentType("text/HTML");
String name="",cemail="";

try{
	CustBean cb=(CustBean)session.getAttribute("activesess");

	 name=cb.getEname();
	 cemail=cb.getEemail();
	 session.setAttribute("activesess", cb);
}
catch(Exception e){
	System.out.println("Session Object Empty");
	e.printStackTrace();
	response.sendRedirect("custlogin.jsp");

	
}
%>



</head>
<body>
<div align="right" style="position: relative;"><a href="custprofile">PROFILE</a> []  <a href="logout" >Logout</a> </div>
<br><br>
<%

CustBean b=new CustBean();
b.setEemail(cemail);

mydoau d=new mydoau();
ResultSet rs=d.viewCust(b);
while(rs.next())
{
%>	

<table align="center">
<tr>
<td>Customer ID </td>
<td><%=rs.getString(1) %></td>
</tr>
<tr>
<td>Name </td>
<td><%=rs.getString(2) %>
</tr>
<tr>
<td>Address </td>
<td><%=rs.getString(3) %>
</tr>
<tr>
<td>Email </td>
<td><%=cemail %>
</tr>
<tr>
<td>Contact </td>
<td><%=rs.getString(4) %>
</tr>
<tr>
<td>Date Of Birth</td>
<td><%=rs.getString(5) %>
</tr>
<tr>
<td>Gender </td>
<td><%=rs.getString(6) %>
</tr>
<tr>
<td>State </td>
<td><%=rs.getString(7) %>
</tr>
<tr>
<td>City </td>
<td><%=rs.getString(8) %>
<%} %>
</tr>
</table>
</body>
</html>