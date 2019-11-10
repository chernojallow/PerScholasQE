<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Yearly Premium</title>
</head>
<body style="text-align:center;">
	<h1>Yearly Premium</h1>
	
	<h2>&#36;<fmt:formatNumber type="number" maxFractionDigits="2" value="${home.homeValue * 0.05}"/></h2>
	<form action="${pageContext.request.contextPath}/HomeServlet/createQuote" method="post">
		<p> <input type="submit" name="createQuote" value="Checkout" /> </p>
	</form>
</body>
</html>