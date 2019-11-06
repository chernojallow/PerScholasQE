<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body style="text-align:center;">
	<h1>Welcome ${currentUser.firstName} ${currentUser.lastName}!</h1>
	<%@ include file="Navigation.html" %>
</body>
</html>