<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div>
	<h1 align="center">Customer Login </h1>
<form action="custlogin" method="post">
<table align="center">
<tr>
<td>Customer Email</td>
<td><input type="text" name="email" placeholder="Enter Your Email ID"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="pass" placeholder="Enter Password"></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit"  value="Login">

</td>
</tr>

</table>

</form>
	
</div>
<br><br>
<div align="center"><a href="newcust.jsp">New Customer ! Register Here</a></div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>