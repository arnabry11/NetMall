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
	<h1 align="center">Seller Login </h1>
<form action="sellerlogin" method="post">
<table align="center">
<tr>
<td>Seller ID</td>
<td><input type="text" name="id" placeholder="Enter Seller ID"></td>
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

</body>
</html>