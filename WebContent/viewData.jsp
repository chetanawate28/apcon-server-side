
<%@page import="com.apcon.db.DBConnectionManager"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.apcon.model.dataBean"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> --%>
<title>View Data</title>
</head>
<body>
<h3 style="text-align:center;">Person Information</h3>
 <table  border=1 cellpadding=10px style="margin:60px auto;">
 	<tr style="background-color:#cc9999 ;"> 
 		<th >Id	</th>
 		<th >Name</th>
 		<th >emailId</th>
 		<th >mb Number</th>
 		<th>DOB</th>
 	</tr>
 	<%
 		ArrayList<dataBean> databeans=(ArrayList<dataBean>)request.getAttribute("getviewData");
 		Iterator it= databeans.iterator();
 		while(it.hasNext())
 		{
 			dataBean db=(dataBean)it.next();	
 		
 	%>
 	<tr style="background-color:#9999cc ;">
 	<td>
 			<% 
 				out.print(db.getId());
 			%>
 	</td>
 	<td>
 			<% 
 				out.print(db.getName());
 			%>
 	</td>
 	<td>
 			<% 
 				out.print(db.getEmail());
 			%>
 	</td>
 	<td>
 			<% 
 				out.print(db.getMbnum());
 			%>
 	</td>
 	<td>
 			<% 
 				out.print(db.getDob());
 			%>
 	</td>
 	
 	</tr>
 	
 	<% 
 		}
 	%>
 </table>
 
</body>
</html>