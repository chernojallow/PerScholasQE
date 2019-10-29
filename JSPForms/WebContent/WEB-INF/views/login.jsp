<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<!-- The Java code on this page will run any time the page is loaded. However, 
	the outer if statement below will not run unless the "Login" button has been clicked. 
	-->
<%
	String error = null;
	if (request.getParameter("login") != null) {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		if (userName.equals("testUser") && userPassword.equals("testPassword")) {
			response.sendRedirect("success.jsp");
		} else {
			error = "Login unsuccessful.";
		}
	}
%>
</head>
<body>
	<h1>Login Form</h1>

	<%
		if (error != null) {
	%>
	<p style="color: red;"><%=error%></p>
	<%
		}
	%>

	<form method="post">
		<label>User Name:&nbsp;<input type="text" name="userName" /></label>
		<label>Password:&nbsp;<input type="password"
			name="userPassword" /></label> <input type="submit" name="login"
			value="Login" />
	</form>
</body>
</html>