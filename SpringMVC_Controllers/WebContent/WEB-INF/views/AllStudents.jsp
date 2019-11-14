<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
</head>
<body>
	<h1>All Students</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${allStudents.values()}" var = "student" >
			<tr>
				<td>${student.studentId}</td>
				<td>${student.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>