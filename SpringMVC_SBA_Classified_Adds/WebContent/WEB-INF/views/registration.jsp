<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Registration Page</h1>
	
	<form:form action="${pageContext.request.contextPath}/login"
	   method="get" modelAttribute="user">
	   <fieldset>
		<table>
			<tr>
				<td><label for="username">Username: </label></td>
				<td><form:input type="text" path="username" placeholder="username123" name="username"/></td>
			</tr>
			
			<tr>
				<td><label for="password">Password: </label></td>
				<td><form:input type="password" path="password" placeholder="password123" name="password"/></td>
			</tr>

			<tr>
				<td><input type="submit" name="registerbtn" value="Register"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
		</fieldset>
	</form:form>
	
	<a href="${pageContext.request.contextPath}/">Return to login page</a>
</body>
</html>