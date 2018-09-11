<%@page import="com.shopping.beans.SellerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    
    
   import ="java.io.IOException"

import ="java.io.PrintWriter"

import ="javax.servlet.RequestDispatcher"
import ="javax.servlet.ServletException"
import ="javax.servlet.annotation.WebServlet"
import ="javax.servlet.http.HttpServlet"
import ="javax.servlet.http.HttpServletRequest"
import="javax.servlet.http.HttpServletResponse"
import ="javax.servlet.http.HttpSession"
import="com.shopping.beans.SellerBean"
 
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
  
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
	//request.getSession(false);
	
	//application.setAttribute("custactive", "3");
	
	//out.print("Hello, "+name+"Welcome to Profile");
// 	RequestDispatcher rd=request.getRequestDispatcher("sellerfunctions.jsp");
// 	rd.include(request, response);

%>


</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div align="right" style="position: relative;"> <a href="logout" >Logout</a> </div>
<div > Hello <%=name %>
</div>
<br><br><br>
<div align="center">

<input type="button" value="ADD NEW ITEM" onclick="window.location.href='newitem.jsp'" ><br><br>
<input type="button" value="REMOVE ITEM" onclick="window.location.href='removeitem.jsp'"><br><br>
<input type="button" value="UPDATE EXISTING ITEM" onclick="window.location.href='updateitem.jsp'"><br><br>
<input type="button" value="VIEW ITEM DETAILS" onclick="window.location.href='viewitem.jsp'"><br><br>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>