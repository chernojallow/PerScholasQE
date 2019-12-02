<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success Page</title>
</head>
<body>
	<h1>Congratulations! You're signed up.</h1>
	<%@ include file="Header.jsp" %>
	<p id="success_userName">Name: ${allParams.get("name")}</p>
	<p id="success_email">Email: ${allParams.get("email")}</p>
	<p id="success_location">Location: ${allParams.get("location") }</p>
	<p id="success_course">Course: ${allParams.get("course") }</p>
	<label>Languages: </label>
	<p id="success_languages1">${allParams.get("languages1")}</p>
	<p id="success_languages2">${allParams.get("languages2")}</p>
	<p id="success_languages3">${allParams.get("languages3")}</p>
	<p id="success_languages4">${allParams.get("languages4")}</p>
	<p id="success_startDate">Start Date: ${allParams.get("startDate")}</p>
	<a href="/qeb_selenium_lesson/">Back to Sign-up Page</a>
	<a href="/qeb_selenium_lesson/bookstore">Buy Books</a>
</body>
</html>