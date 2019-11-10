<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/UpdateProfile" method="post">
        New Username: <input type="text" name="username" required><br>
        New Password: <input type="password" name="password" required><br>
        <input type="hidden" name="uid" value="${uid}"><br>
        <input type="submit" name="submit" value="Update">
    </form>
</body>
</html>