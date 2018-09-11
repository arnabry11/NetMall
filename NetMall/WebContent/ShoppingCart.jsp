<%@page import="java.io.PrintWriter"%>
<%@page import="com.shopping.beans.CustBean"%>
<%@page import="com.shopping.beans.CartItemBean"%>
<%@page import="com.shopping.beans.CartBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Cart</title>
<% PrintWriter pw=response.getWriter();
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
CartBean cb=(CartBean)session.getAttribute("cart");
int count=0;
double ctotal=0;

//System.out.println(cb);
	
	if(cb!=null)
	{
	session.setAttribute("cart", cb);
	
	}
	else{
		response.sendRedirect("custprofile");
	}
	
	

/* if (session.getAttribute("cart") == null || session.getAttribute("cart").equals("") || caaab==null)
{
	response.sendRedirect("custprofile");
}
 */
 //CartBean cb=(CartBean)session.getAttribute("cart");
//session.setAttribute("cart", cb);



%>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div><a href="custprofile">Go Back</a></div>
<div align="center">

<table>
<% 
try{
for(int i=0;i<cb.getLineItemCount();i++)
{	
	CartItemBean cib=cb.getCartItems(i);

%>
<tr>
<td><%=cib.getEname()%></td><td> =  <%=cib.getEquantity()%> units</td><td><form action="CartController"><input type="text" name="quantity" size="2"><input type="hidden" name="action" value="Update"><input type="hidden" name="index" value="<%=i%>"><input type="submit" value="Change Quantity"></form></td>
</tr>
<tr>
<td></td>
<td></td>
<td><form action="CartController"><input type="hidden" name="action" value="Delete"><input type="hidden" name="deleteindex" value="<%=i%>"><input type="submit" value="Delete"></form></td>
</tr>

<%
}
%>
</table>
</div>
<%
 ctotal=cb.getCartsum();
}catch(Exception e){
	e.printStackTrace();
	out.print("<script>alert('Cart is Empty !')</script>");
	RequestDispatcher rd=request.getRequestDispatcher("custfunctions.jsp");
	rd.include(request, response);
}
%>
<div position= "relative">
CART TOTAL=<%=ctotal %><br>
<input type="button" value="Proceed To Checkout" onclick="window.location.href='checkout.jsp'">

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>