<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Add Subuser</title>
</head>
<body>
	<h1>Add Subuser</h1>
		<p class="error">${errorMessage}</p>
	
	<form:form action="${pageContext.request.contextPath}/registerSubuser" method="post" modelAttribute="subuser">
		<fieldset>
			<p> <label>Username:&nbsp;<form:input path="username" placeholder="username123" required="required"/> </label> </p>
			<p> <form:errors path="username" class="error" /> </p>
			
			<p> <label>Password:&nbsp;<form:input path="password" type="password" placeholder="password123" required="required" /> </label> </p>
			<p> <form:errors path="password" class="error" /> </p>
			
			<p> <input type=submit value="Register" /> <input type="reset" value="Clear"/> </p>
		</fieldset>
	</form:form>
</body>
</html>