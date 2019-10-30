<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	<header> <h1>Log In</h1> </header>
	
	<% if (request.getAttribute("loginError") != null) {%>
	    <p style="color: red;"><%= request.getAttribute("loginError") %></p>
	<% } %>
	
	<% if (request.getAttribute("regSuccess") != null) {%>
	    <p style="color: green;"><%= request.getAttribute("regSuccess") %></p>
	<% } %>
	
	<form action="redirect.jsp" method="post">
		<p> <label>User Name:&nbsp;<input type="text" name="loginUsername" required/> </label> </p>
		<p> <label>Password:&nbsp;<input type="password" name="loginPassword" required/> </label> </p>
		<p> <input type="submit" name="login" value="Login"/> 
		<input type="reset"/></p>
	</form>
	
	<p> <a href="register.jsp">Click to register account</a> </p>
</body>
</html>