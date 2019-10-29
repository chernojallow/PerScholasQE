<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
	</head>
<body>
	<h1>Login Form</h1>
	<% if (request.getAttribute("error") != null) {%>
	    <p style="color: red;"><%= request.getAttribute("error") %></p>
	<% } %>
	
	<form action="views/success.jsp" method="post">
		<label>User Name:&nbsp;<input type="text" name="userName" /></label>
		<label>Password:&nbsp;<input type="password" name="userPassword" /></label>
		<input type="submit" name="login" value="Login" />
	</form>
</body>
</html>