<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Profile</title>
</head>
<body>
	<h1>${currentMember.name} Profile</h1>
	<%@ include file="Navigation.html" %>
	<h2>Email: ${currentMember.email}</h2>
	<h2>Favorite Language: ${currentMember.favoriteLanguage}</h2>
	<a href="${pageContext.request.contextPath}/showUpdatePage">Update Profile</a>
</body>
</html>