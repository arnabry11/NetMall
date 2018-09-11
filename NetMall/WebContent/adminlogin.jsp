<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN LOGIN</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div>

<h1 align="center">Admin </h1>
<form action="adminlogin" method="post">
<table align="center">
<tr>
<td>Name</td>
<td><input type="text" name="name" placeholder="Enter Name"></td>
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

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>