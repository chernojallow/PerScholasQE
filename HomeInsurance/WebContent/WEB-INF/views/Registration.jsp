<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body style="text-align:center;">
	<h1>Registration Page</h1>
	<form action="${pageContext.request.contextPath}/HomeServlet/registerUser" method="post">
		<p> <label>First Name:&nbsp;<input name="firstName" required/> </label> </p>
		<p> <label>Last Name:&nbsp;<input name="lastName" required/> </label> </p>
		<p> <label>Email:&nbsp;<input type="email" name="email" required/> </label> </p>
		<p> <label>Username:&nbsp;<input name="username" required/> </label> </p>
		<p> <label>Password:&nbsp;<input type="password" name="password" required/> </label> </p>
		<p> <label>DOB:&nbsp;<input type="date" name="dob" required/> </label> </p>
		<p> <input type=submit value="Register" /> <input type="reset"/> </p>
	</form>
	<a href="${pageContext.request.contextPath}/HomeServlet">Return to login</a>
</body>
</html>