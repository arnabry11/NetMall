<%@page import="com.shopping.beans.CustBean"%>
<%@page import="com.shopping.doau.mydoau"%>
<%@page import="com.shopping.beans.CartItemBean"%>
<%@page import="com.shopping.beans.CartBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
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




if (session.getAttribute("cart") == null || session.getAttribute("cart").equals(""))
{
	System.out.println("Redirect due no session");
	response.sendRedirect("logout");
}
CartBean cb=(CartBean)session.getAttribute("cart");

String itemid[]=new String[cb.getLineItemCount()];
int qua[]=new int[cb.getLineItemCount()];
int stock[]=new int[cb.getLineItemCount()];
for(int i=0;i<cb.getLineItemCount();i++)
{	
	CartItemBean cib=cb.getCartItems(i);
	itemid[i]=cib.getEid();
	qua[i]=cib.getEquantity();	
	stock[i]=cib.getEstock();
}
for(int i=0;i<itemid.length;i++)
{
mydoau d=new mydoau();
int newstock=stock[i]-qua[i];
int result=d.updateStock(itemid[i],newstock);
}

session.setAttribute("cart", null); 
%>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<div><a href="custprofile">Go Back</a></div><br><br>
<div align="center">

Your Order Has Been Successfully Placed

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>