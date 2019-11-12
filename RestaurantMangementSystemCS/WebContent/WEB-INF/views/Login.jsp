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
	<p style="color: green;">${successMeesage}</p>
	<p style="color: red;">${errorMessage}</p>
	
	<form action="${pageContext.request.contextPath}/loginUser" method="post">
		<p> <label>Username:&nbsp;<input name="username" placeholder="username123" required/> </label> </p>
		<p> <label>Password:&nbsp;<input name="password" type="password" placeholder="password123" required/> </label> </p>
		<p> <input type="submit" value="Login" /> <input type="reset" value="Clear"/></p>
	</form>
	
	<a href="${pageContext.request.contextPath}/register">Register Here</a>
</body>
</html>