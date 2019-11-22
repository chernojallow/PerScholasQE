<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login Page</h1>
	
	<form:form action="${pageContext.request.contextPath}/checkLogin" 
	  method="post" modelAttribute="user2">
	  	<fieldset>
		<table>
			<tr>
				<td><label for="username">Username: </label></td>
				<td><form:input type="text" path="username" placeholder="username123" required="required"/></td>
			</tr>
			
			<tr>
				<td><label for="password">Password: </label></td>
				<td><form:input type="password" path="password" placeholder="password123" required="required"/></td>
			</tr>
			
			<tr> 
				<td><input type="submit"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/register">Register</a></td>
			</tr>
		</table>
		</fieldset>
	</form:form>
</body>
</html>