<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In Redirect</title>
</head>
<body>
	<%	String loginUN = request.getParameter("loginUsername");
		String loginPass = request.getParameter("loginPassword");

		if (!loginUN.equals("testUser") || !loginPass.equals("testPassword")) {
			request.setAttribute("loginError", "Login unsuccessful.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
	%>
</body>
</html>