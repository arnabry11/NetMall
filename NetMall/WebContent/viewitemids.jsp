<%@page import="com.shopping.beans.SellerBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.shopping.doau.mydoau"%>
<%@page import="com.shopping.beans.ItemBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
SellerBean sb=(SellerBean)session.getAttribute("activesess");
String seid=sb.getEid();
session.setAttribute("activesess", sb);




response.setContentType("text/html");
//String eid=request.getParameter("id");
ItemBean ib=new ItemBean();
//ib.setEid(eid);
ib.setEseller_id(seid);

mydoau d=new mydoau();
ResultSet rs=d.viewAllItem(ib);
%>


</head>
<body>
<div align="right"><a href="viewitem.jsp?sid=<%=seid%>"><b>Go Back</b></a></div>
<div>

<table>
<tr><td>.............ITEM ID..............</td><td>.............ITEM NAME................</td></tr>
<%while(rs.next())
{
 %>
 <tr><td><%=rs.getString(1) %></td>        <td><%=rs.getString(2) %></td></tr>
    <% }%>
</table>



</div>


</body>
</html>