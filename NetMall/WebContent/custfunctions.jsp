<%@page import="java.sql.ResultSet"%>
<%@page import="com.shopping.doau.mydoau"%>
<%@page import="com.shopping.beans.CustBean"%>
<%@page import="com.shopping.beans.ItemBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Profile</title>
</head>
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
// 	out.println("<p style=\" font-size: x-large;font-family: cursive;font-style: oblique; color: red;\">Please Login First</p>");
// 	RequestDispatcher rd=request.getRequestDispatcher("custlogin.jsp");
// 	rd.include(request, response);
	
}




%>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="width:100%;">
<div align="right" style="position: relative;"> <input type="button" value="LOGOUT" onclick="window.location.href='logout'"> </div>
<div style=" float:left;width:500px;position: relative;"><strong> Hello <%=name %></strong></div>
<div style=" float:center;position: relative;">


<input type="button" value="UPDATE YOUR DETAILS" onclick="window.location.href='updatecust.jsp'">
<input type="button" value="VIEW YOUR DETAILS" onclick="window.location.href='viewcust.jsp'"><br><br>

</div>
</div>

<p align="center"><font size="3" face="Verdana, Arial, Helvetica, sans-serif"><strong>AVAILABLE ITEMS</strong></font></p>
<div align="center"><a href="ShoppingCart.jsp">View Cart</a></div>
<div align="center">
<table width="35%" border="1" align="center">
<%
		mydoau d=new mydoau();
		ResultSet rs=d.retrieveAllItems();
		while(rs.next())
		{
			String itid=rs.getString(2);

%>
  <tr align="center">
    <td><form  method="POST" action="CartController" >
 <font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Item Name:</strong>
       <%=rs.getString(3) %> </font><input type="hidden" name="modelNo" value="<%=rs.getString(3)%>">
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Description:</strong>
        <%=rs.getString(5) %></font><input type="hidden" name="description" value="<%=rs.getString(5)%>" ></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Quantity:<input type="text" size="2" value="1" name="quantity"></strong></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Price:</strong>
        <%=rs.getString(4)%> INR</font><input type="hidden" name="price" value="<%=rs.getString(4)%>"><input type="hidden" name="action" value="add"></p><input type="hidden" name="itemid" value="<%=itid%>">
        <input type="submit" name="button" value="Add To Cart" style="float:left;">
 <input type="submit" value="Buy Now" name="button" style="float:right;">      
      </form> 
       
      </td>
      
      
   <%} 
   	d.closeCon();
   
   %>   
     <!--  <td><form name="modelDetail2" method="POST" action="servlet/CartController"><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Model</strong>:
      TF-Model2 </font><input type="hidden" name="modelNo" value="TF-MODEL2">
<font face="Verdana, Arial, Helvetica, sans-serif">
      <p><font size="2"><strong>Description</strong>: Tech-Freaks imaginary model
        2. </font><input type="hidden" name="description" value="Tech-Freaks imaginary model 2."></p>
      <p><font size="2"><strong>Quantity</strong>: <input type="text" size="2" value="1" name="quantity"></font></p>
      <p><font size="2"><strong>Price</strong>: $20.00<input type="hidden" name="price" value="20"></font></p>
           <input type="hidden" name="action" value="add">
             <input type="submit" name="addToCart" value="Add To Cart">
      </font></form></td> -->
      
     </tr>
</table>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>