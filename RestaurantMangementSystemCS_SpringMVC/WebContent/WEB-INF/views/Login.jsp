<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Login Page</title>
</head>
<body>
	<h1>&emsp;Login Page</h1>
	<p class="text-success">&emsp;${successMessage}</p>
	<p class="text-danger">&emsp;${errorMessage}</p>
	
	<form:form action="${pageContext.request.contextPath}/loginUser" method="post" modelAttribute="login">
		<form:input path="userId" type="hidden" value="-1"/>
		<form:input path="addressId" type="hidden" value="-1"/>
		<form:input path="role" type="hidden" value="-1"/>
		
		<p> <label>&emsp;Username:&nbsp;<form:input path="username" placeholder="username123" required="required"/> </label> </p>
		<p> <form:errors path="username" class="error"/> </p>
		
		<p> <label>&emsp;Password:&nbsp;<form:input path="password" type="password" placeholder="password123" required="required"/> </label> </p>
		<p> <form:errors path="password" class="error"/> </p>
		
		<p>&emsp;<input type="submit" value="Login" />&emsp;<input type="reset" value="Clear"/></p>
	</form:form>
	
	<p>&emsp;<a href="${pageContext.request.contextPath}/register">Register Here</a> </p>
</body>
</html>