<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Page</title>
	<% 	String un = request.getParameter("loginUsername");%>
</head>
<body>
	<h1>Welcome <%=un %>! You have successfully logged in.</h1>
</body>
</html>