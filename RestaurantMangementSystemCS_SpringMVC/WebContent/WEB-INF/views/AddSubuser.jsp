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
<title>Add Subuser</title>
</head>
<body>
	<h1>&emsp;Add Subuser</h1>
	<p>&emsp;<%@ include file="Navigation.html" %> </p>
	
	<form:form action="${pageContext.request.contextPath}/registerSubuser" method="post" modelAttribute="subuser">
		<fieldset>
			<form:input path="userId" type="hidden" value="-1"/>
			<form:input path="addressId" type="hidden" value="${currentUser.addressId}"/>
			
			<p> <label>&emsp;Username:&nbsp;<form:input path="username" placeholder="username123" required="required"/> </label> </p>
			<p> <form:errors path="username" class="error" /> </p>
			
			<p> <label>&emsp;Password:&nbsp;<form:input path="password" type="password" placeholder="password123" required="required" /> </label> </p>
			<p> <form:errors path="password" class="error" /> </p>
			
			<p> <label>&emsp;Role:&nbsp;<form:select path="role">
				<option value="2">Manager</option>
				<option value="3">Waiter/Waitress</option>
			</form:select> </label> <p>
			<p> <form:errors path="role" class="error" /> </p>
			
			<p>&emsp;<input type=submit value="Register" />&emsp;<input type="reset" value="Clear"/> </p>
		</fieldset>
	</form:form>
	
	<p>&emsp;<a href="${pageContext.request.contextPath}/showProfile">Return to Profile</a> </p>
</body>
</html>