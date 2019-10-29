<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Page</title>
<%
	String userName = request.getParameter("userName");
	String userPassword = request.getParameter("userPassword");

	if (!userName.equals("testUser") || !userPassword.equals("testPassword")) {
		request.setAttribute("error", "Login unsuccessful.");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	}
%>
</head>
<body>
	<h1>
		Welcome
		<%=userName%>! You have successfully logged in.
	</h1>
</body>
</html>