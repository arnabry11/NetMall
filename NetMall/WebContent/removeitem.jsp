<%@page import="com.shopping.doau.mydoau"%>
<%@page import="com.shopping.beans.SellerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
<div align="right" style="position: relative;"> <a href="logout" >Logout</a> </div><br><br><br><br><br><br><br><br><br>
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
<div>
<h1><i><b>REMOVE ITEM</b></i></h1>
<form action="removeitem1.jsp" method="post">
<input type="text" name="id" placeholder="Enter ITEM ID">
<br>
<input type="submit" value="Submit">
</form>
</div>
<div>

<%
// if(request.getParameter("id") != null && !request.getParameter("id").equals(""))
// {
// 	String eid=request.getParameter("id");
// 	response.setContentType("text/HTML");
// 	if(eid!=null){
			
// 			response.setContentType("text/HTML");
// 			mydoau d=new mydoau();
// 			int result=d.deleteItem(eid,seid);
// 			if(result!=0) {
// 				out.print("<p style=\" color:green;\">Delete Success </p>");
// 				RequestDispatcher rd=request.getRequestDispatcher("removeitem.jsp");
// 				rd.include(request, response);
				
// 			}
// 			else {
// 				out.print("<p style=\" color:red;\"><i>INVALID Item ID  !! Please try again</i></p>");
// 				RequestDispatcher rd=request.getRequestDispatcher("removeitem.jsp");
// 				rd.include(request, response);
						
// 			}
// 	}
// 	else{
// 		response.sendRedirect("sellerlogout");
		
// 	}
// }



//	 %>
</div>

</body>
</html>