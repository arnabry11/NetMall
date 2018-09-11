<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping Site</title>
</head>
<body>



<h1 align="center" style="font-size: x-large; color: orange;">CUSTOMER REGISTRATION</h1>
<form action="newcust" method="post">
<table align="center">
<tr>
	<td style="font-size: 20px;font-style: oblique;color: red;">Enter Name</td>
	<td><input type="text" name="name" placeholder="Name"></td>
</tr>
<tr>
	<td>Enter Address</td>
	<td><input type="text" name="address"placeholder="Address"></td>
</tr>

<tr>
	<td>Enter E-mail</td>
	<td><input type="text" name="email"placeholder="Email"></td>
</tr>

<tr>
	<td>Enter Contact No</td>
	<td><input type="text" name="contact"placeholder="Contact no"></td>
</tr>

<tr>
	<td>Date Of Birth</td>
	<td><input type="date" name="dob"placeholder="Date Of Birth"></td>
</tr>

<tr>
	<td>Gender</td>
	<td id="n1"><input type="radio" name="gender" value="M">M
	<input type="radio" name="gender" value="F">F</td>
</tr>

<tr>
	<td>Enter State</td>
	<td><select name="state">
		<option value="West bengal">West bengal</option>
		<option value="Jharkhand">Jharkhand</option>
		<option value="Bihar">Bihar</option>
		<option value="Delhi">Delhi</option>
		<option value="Uttar Pradesh">Uttar Pradesh</option>
	</select></td>
</tr>

<tr>
	<td>Enter City</td>
	<td><select name="city">
		<option value="Kolkata">Kolkata</option>
		<option value="Dhanbad">Dhanbad</option>
		<option value="Patna">Patna</option>
		<option value="Lucknow">Lucknow</option>
		<option value="India Gate">India Gate</option>
	</select></td>

<tr>
	<td>Enter Password</td>
	<td><input type="password" name="password"placeholder="Password"></td>
</tr>
</tr>

<tr>
	
	<td colspan="2" align="center"><input type="submit" name="sub1" value="Submit"></td>
</tr>

</table>
</form>



</body>
</html>