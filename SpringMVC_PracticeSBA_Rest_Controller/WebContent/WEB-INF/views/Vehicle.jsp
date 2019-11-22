<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vehicle Page</title>
</head>
<body>
	<h1>Vehicle</h1>
	<h2>Vehicle: ${vehicle.make} ${vehicle.model}<span style = "color:red;">${errorMessage}</span></h2>
	<h3>Colors:</h3>
	<c:forEach items = "${vehicle.colors}" var = "color">
		<p>${color}</p>
	</c:forEach>
</body>
</html>