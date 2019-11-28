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
<title>Change Password</title>
</head>
<body>
	<h1>&emsp;Change Password</h1>
	<p>&emsp;<%@ include file="Navigation.jsp" %> </p>
	
	<form:form action="${pageContext.request.contextPath}/changePassword" method="post" modelAttribute="user">
		<p>&emsp;Current Password: ${currentUser.password} </p>
		<form:input path="userId" type="hidden" value="${currentUser.userId}"/>
		<form:input path="username" type="hidden" value="${currentUser.username}"/>
		<form:input path="addressId" type="hidden" value="${currentUser.addressId}"/>
		<form:input path="role" type="hidden" value="${currentUser.role}"/>
		
		<p> <label>&emsp;Password:&nbsp;<form:input path="password" type="password" placeholder="password123" required="required"/> </label> </p>
		<p> <form:errors path="password" class="error"/> </p>
		
		<p>&emsp;<input type="submit" value="Change Password" /> </p>
	</form:form>
	
	<p>&emsp;<a href="${pageContext.request.contextPath}/showProfile">Return to Profile</a> </p>
</body>
</html>