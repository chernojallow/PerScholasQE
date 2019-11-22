<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style>
	.tables {height:100px; width:100px; font-size:20px;}
</style>
<title>Tables</title>
</head>
<body>
	<h1>Tables</h1>
	<p> <%@ include file="Navigation.html" %> </p>	
	
	<c:forEach items="${allTables}" var="table">
		&emsp;&emsp;<button class="tables">Table ${table.tableId}</button>&emsp;&emsp;
	</c:forEach>
</body>
</html>