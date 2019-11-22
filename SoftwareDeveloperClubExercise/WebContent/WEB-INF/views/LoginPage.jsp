<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login Page</h1>
	<p style="color: red;">${errorMessage}</p>
	<a href="${pageContext.request.contextPath}/HomeServlet/showRegistration">Register Here</a>
	<form action="${pageContext.request.contextPath}/HomeServlet/loginMember" method="post">
		<p> <label>Name: <input name="name" /> </label> </p>
		<p> <label>Password: <input name="password" /> </label> </p>
		<p> <input type="submit" value="Login" /> </p>
	</form>
</body>
</html>