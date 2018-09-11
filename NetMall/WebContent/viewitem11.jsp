<%@page import="com.shopping.beans.SellerBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.shopping.doau.mydoau"%>
<%@page import="com.shopping.beans.ItemBean"%>
<%@page import="java.io.PrintWriter"%>
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
<div align="right"><a href="viewitem.jsp"><b>Go Back</b></a></div><div align="right" style="position: relative;"> <a href="logout" >Logout</a> </div>

<%

PrintWriter ps=response.getWriter();
response.setContentType("text/html");
String eid=request.getParameter("id");
ItemBean ib=new ItemBean();
ib.setEid(eid);
ib.setEseller_id(sid);

mydoau d=new mydoau();
ResultSet rs=d.viewItem(ib);
int k=0;
while(rs.next())
{
	k=1;
%>	
<table>
<tr>
<td>Name </td>
<td><%=rs.getString(1) %></td>
</tr>
<tr>
<td>Price </td>
<td><%=rs.getString(2) %>
</tr>
<tr>
<td>Description </td>
<td><%=rs.getString(3) %>
</tr>
<tr>
<td>Stock </td>
<td><%=rs.getString(4) %>
</tr>
<%} %>

<% 
if(k==0){
	
	out.println("Wrong Item ID .. Please Try Again");
	RequestDispatcher rd=request.getRequestDispatcher("viewitem1.jsp?sid="+sid );
	rd.include(request, response);
}
%>
</table>




</body>
</html>