<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Page</title>
</head>
<body>
	<h1>Student Page</h1>
	<a href="${pageContext.request.contextPath}/allStudents">Student List</a>
	<h2>Name: ${student.name}<span style="color:red;">${errorMessage}</span></h2>
	<c:if test="${student.email != null}">
	<h2>Email: ${student.email}</h2>
	</c:if>
	<a href="${pageContext.request.contextPath }/updateStudentForm
		/${student.studentId}">Edit</a>
</body>
</html>