
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/demoservlet.css">
<body>
	<form action="LoginController" method="get">
	<div class="login">	
	<table style="margin:100px auto;padding: 10px;border-style: solid;border-color: gray; ">
	<tr>
	<td> Username :</td>
	<td> <input class="inputText" type="text" name="username"></td>
	</tr>
	<tr>
	<td> Password :</td>
	<td> <input class="inputText" type="password" name="password"></td>
	</tr>
	<tr><td colspan="2" style=""><input type="submit" value="Login" class="loginButton"></td></tr>
	</table>
	<!-- <form action="LoginController" method="get">
		
		 Username :  <input class="inputText" type="text" name="username"><BR>
		 Password :  <input class="inputText" type="password" name="password"><BR>
		<input type="submit" value="Login" class="loginButton">
		
	</form> -->
	</div>
	</form>
</body>
</html>