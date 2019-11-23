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
<title>Setup</title>
</head>
<body>
	<h1>&emsp;Setup</h1>
	<p>&emsp;<%@ include file="Navigation.html" %> </p>
	
	<h3>&emsp;Number of Tables: ${nbrOfTables}</h3>
	<form action="${pageContext.request.contextPath}/editTables" method="post">
		<p> <label>&emsp;Change Number of Tables:&nbsp;<input name="tables" type="number" required="required"/> </label> </p>
		<p>&emsp;<input type=submit value="Apply" />
	</form>
	
</body>
</html>