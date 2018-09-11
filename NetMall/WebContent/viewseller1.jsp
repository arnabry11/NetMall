<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import ="javax.servlet.ServletException"
import="javax.servlet.annotation.WebServlet"
import ="javax.servlet.http.HttpServlet"
import ="javax.servlet.http.HttpServletRequest"
import ="javax.servlet.http.HttpServletResponse"
import ="java.sql.ResultSet"
import ="com.shopping.doau.mydoau"
import ="com.shopping.beans.SellerBean" 
import ="java.io.PrintWriter"
import ="javax.servlet.RequestDispatcher"

    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping Site</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div align="right"><a href="adminfunctions.jsp">Admin Tasks</a></div>
<div align="center">
<%

PrintWriter ps=response.getWriter();
response.setContentType("text/html");
String eid=request.getParameter("id");
SellerBean sb=new SellerBean();
sb.setEid(eid);

mydoau d=new mydoau();
ResultSet rs=d.view(sb);
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
<td>Address </td>
<td><%=rs.getString(4) %>
</tr>
<tr>
<td>Email </td>
<td><%=rs.getString(3) %>
</tr>
<tr>
<td>Contact </td>
<td><%=rs.getString(2) %>
</tr>
<tr>
<td>State  </td>
<td><%=rs.getString(6) %>
</tr>
<tr>
<td>City </td>
<td><%=rs.getString(5) %>
</tr>
<tr>
<td>PIN </td>
<td><%=rs.getString(7) %>
<%} 

if(k==0){
	
	ps.println("Wrong Seller ID .. Please Try Again");
	RequestDispatcher rd=request.getRequestDispatcher("viewseller.jsp");
	rd.include(request, response);
}
%>
</tr>
</table>


</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>