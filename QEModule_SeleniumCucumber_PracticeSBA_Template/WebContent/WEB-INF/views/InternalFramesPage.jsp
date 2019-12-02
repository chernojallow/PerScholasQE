<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Internal Frame Page</title>

</head>
<body>
	<header>
		<h1>Internal Frame Page</h1>
		<%@ include file="Header.jsp" %>
	</header>
	<iframe src="http://localhost:8080${pageContext.request.contextPath}/showFirstFrame" name="Per Scholas">
		<p>Your browser does not support iFrames</p>
	</iframe>
	<iframe src="http://localhost:8080${pageContext.request.contextPath}/showSecondFrame" name="Platform">
		<p>Your browser does not support iFrames</p>
	</iframe>
</body>
</html>