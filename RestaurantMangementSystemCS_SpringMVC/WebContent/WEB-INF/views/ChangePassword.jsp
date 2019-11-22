<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style>
	.error {color: red;}
</style>
<title>Change Password</title>
</head>
<body>
	<h1>Change Password</h1>
	<p> <%@ include file="Navigation.html" %> </p>
	<p style="color: red;">${errorMessage}</p>
	
	<form:form action="${pageContext.request.contextPath}/changePassword" method="post" modelAttribute="user">
		<fieldset>
			<p> Current Password: ${currentUser.password} </p>
			<form:input path="userId" type="hidden" value="${currentUser.userId}"/>
			<form:input path="username" type="hidden" value="${currentUser.username}"/>
			<form:input path="addressId" type="hidden" value="${currentUser.addressId}"/>
			<form:input path="role" type="hidden" value="${currentUser.role}"/>
			
			<p> <label>Password:&nbsp;<form:input path="password" type="password" placeholder="password123" required="required"/> </label> </p>
			<p> <form:errors path="password" class="error"/> </p>
			
			<p> <input type="submit" value="Change Password" /> </p>	
		</fieldset>
	</form:form>
	
	<p> <a href="${pageContext.request.contextPath}/showProfile">Return to Profile</a> </p>
</body>
</html>