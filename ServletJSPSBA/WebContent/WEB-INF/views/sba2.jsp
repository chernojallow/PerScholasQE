<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SBA2</title>
</head>
<body>
	<h1>SBA2</h1>
	
	<form action="${pageContext.request.contextPath}/SBA2Servlet" method="post">
		<p> <label>Username:&nbsp;<input name="username" required/> </label> </p>
		<p> <label>Password:&nbsp;<input name="password" type="password" required/> </label> </p>
		<p> <input type="submit" value="Login" /> <input type="reset"/></p>
	</form>
</body>
</html>