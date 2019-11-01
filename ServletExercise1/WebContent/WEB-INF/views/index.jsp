<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servlet Exercise</title>
</head>
<body>
	<h1>Servlet Exercise 1</h1>
	
	<form action="${pageContext.request.contextPath}/HomeServlet" method="post">
		Username: <input type="text" name="username"><br>
		Password: <input type="text" name="password"><br>
		<input type="submit" value="submit" name="submit">
	</form>
</body>
</html>