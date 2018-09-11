<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Functions For Admin</title>
<%
application.setAttribute("adminactive", "1");
%>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<br><br><br><br><br>


<div class="box" align = "center" >

<input type="button" value="ADD NEW SELLER" onclick="window.location.href='newseller.jsp'"><br><br>
<input type="button" value="REMOVE SELLER" onclick="window.location.href='removeseller.jsp'"><br><br>
<input type="button" value="UPDATE EXISTING SELLER" onclick="window.location.href='updateseller.jsp'"><br><br>
<input type="button" value="VIEW SELLER DETAILS" onclick="window.location.href='viewseller.jsp'"><br><br>


</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>