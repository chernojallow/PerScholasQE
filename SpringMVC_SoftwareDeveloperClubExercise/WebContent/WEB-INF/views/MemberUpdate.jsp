<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Update</title>
</head>
<body>
	<h1>Member Update</h1>
	<form action="${pageContext.request.contextPath}/updateMember" method="post">
		<div>
			<label>Member Name:</label>
			<input name="name" value="${currentMember.name}"/>
		</div>
		<div>
			<label>Email:</label>
			<input name="email" value="${currentMember.email}"/>
		</div>
		<div>
			<label>Password:</label>
			<input name="password" value="${currentMember.password}"/>
		</div>
		<div>
			<label>Favorite Language:</label>
			<input name="favoriteLanguage" value="${currentMember.favoriteLanguage}"/>
		</div>
		<div>
			<input type=submit value="Update" />
		</div>
	</form>
	<a href="${pageContext.request.contextPath}/showProfile">Back to Member Profile</a>
</body>
</html>