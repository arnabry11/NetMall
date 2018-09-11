<%@page import="java.sql.ResultSet"%>
<%@page import="com.shopping.doau.mydoau"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping Site</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


<div> 

<table width="75%" border="1">
<%
		mydoau d=new mydoau();
		ResultSet rs=d.retrieveAllItems();
		while(rs.next())
		{


%>
  <tr>
    <td><form  method="POST" action="custlogin.jsp">
 <font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Item Name:</strong>
       <%=rs.getString(3) %> </font><input type="hidden" name="modelNo" value="<%=rs.getString(3)%>">
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Description:</strong>
        <%=rs.getString(5) %></font><input type="hidden" name="description" value="<%=rs.getString(5)%>" ></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Quantity:<input type="text" size="2" value="1" name="quantity"></strong></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Price:</strong>
        <%=rs.getString(4)%> INR</font><input type="hidden" name="price" value="<%=rs.getString(4)%>"><input type="hidden" name="action" value="add"></p><input type="hidden" name="itemid" value="<%=rs.getString(2)%>"><input type="submit" name="addToCart" value="Add To Cart">
      </form></td>
      
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