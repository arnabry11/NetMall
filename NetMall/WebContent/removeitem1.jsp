<%@page import="com.shopping.beans.SellerBean"%>
<%@page import="com.shopping.doau.mydoau"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<% 

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


String eid=request.getParameter("id");
response.setContentType("text/HTML");
if(eid!=null){
		
		response.setContentType("text/HTML");
		mydoau d=new mydoau();
		int result=d.deleteItem(eid,sid);
		d.closeCon();
		if(result!=0) {
			out.print("<script>alert(\"Delete Successful\")</script>");
			RequestDispatcher rd=request.getRequestDispatcher("sellerprofile");
			rd.include(request, response);
			
		}
		else {
			out.print("<script><p style=\" color:red;\"><i>alert('INVALID Item ID  !! Please try again')</i></p></script>");
			RequestDispatcher rd=request.getRequestDispatcher("removeitem.jsp");
			rd.include(request, response);
					
		}
}
else{
	response.sendRedirect("logout");
	
}
		%>
</head>
<body>
<div align="center">


</div>
</body>
</html>