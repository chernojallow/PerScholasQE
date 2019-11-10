<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.time.format.DateTimeFormatter" %>  
<%@page import="java.time.LocalDateTime" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SBA1</title>
</head>
<body>
	<h1>Welcome</h1>
	<h2>Time: 
	<%
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd yyyy h:mm a");
		LocalDateTime ldt = LocalDateTime.now();
		
		String ldtstr = ldt.format(dtf);
	%>
	<%=ldtstr%>
	</h2>
</body>
</html>