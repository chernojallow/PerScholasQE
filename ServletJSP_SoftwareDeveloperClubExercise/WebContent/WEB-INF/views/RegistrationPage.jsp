<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<h1>Registration Page</h1>
	<form action="${pageContext.request.contextPath}/HomeServlet/registerMember" method="post">
			<p> <label>Member Name:&nbsp;<input name="name" required/> </label> </p>
			<p> <label>Email:&nbsp;<input name="email" required/> </label> </p>
			<p> <label>Password:&nbsp;<input name="password" type="password" required/> </label> </p>
			<p> <label>Favorite Genre:&nbsp;<input name="fGenre" required/></label> </p>
			<p> <input type=submit value="Register" /> <input type="reset"/> </p>
	</form>
	
	<a href="${pageContext.request.contextPath}/HomeServlet">Return to login</a>
</body>
</html>