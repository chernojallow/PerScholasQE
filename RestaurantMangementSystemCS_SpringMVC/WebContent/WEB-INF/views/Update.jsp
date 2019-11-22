<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
	<h1>Update Profile</h1>
	<p> <%@ include file="Navigation.html" %> </p>
	<p style="color: red;">${errorMessage}</p>
	
	<form:form action="${pageContext.request.contextPath}/updateProfile" method="post" modelAttribute="profile">
		
	</form:form>
	
	
	<form:form action="${pageContext.request.contextPath}/updateProfile" method="post" modelAttribute="login">
		<fieldset>
			<p> <label>Username:&nbsp;<form:input path="username" placeholder="username123" required="required"/> </label> </p>
			<p> <form:errors path="username" class="error"/> </p>
			
			<p> <label for="password">Password:&nbsp;<form:input path="password" type="password" placeholder="password123" required="required"/> </label> </p>
			<p> <form:errors path="password" class="error"/> </p>
			
			<p> <input type="submit" value="Login" /> <input type="reset" value="Clear"/></p>
		</fieldset>
	</form:form>
	
	<p> <a href="${pageContext.request.contextPath}/showProfile">Return to Profile</a> </p>
</body>
</html>