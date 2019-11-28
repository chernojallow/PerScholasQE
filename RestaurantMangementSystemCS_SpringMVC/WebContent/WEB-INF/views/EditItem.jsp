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
<title>Edit ${item.itemName} Item</title>
</head>
<body>
	<h1>&emsp;Edit ${item.itemName} Item</h1>
	<p>&emsp;<%@ include file="Navigation.jsp" %> </p>
	
	<form:form action="${pageContext.request.contextPath}/editItem" method="post" modelAttribute="newItem">
		<form:input path="itemId" type="hidden" value="${item.itemId}"/>
		<form:input path="categoryId" type="hidden" value="${item.categoryId}"/>
		
		<p> <label>&emsp;Item Name:&nbsp;<form:input path="itemName" placeholder="name" required="required" value="${item.itemName}"/> </label> </p>
		<p> <form:errors path="itemName" class="error" /> </p>
		
		<p> <label>&emsp;Item Price:&nbsp;$<form:input path="price" placeholder="4.99" required="required" type="number" value="${item.price}"/> </label> </p>
		<p> <form:errors path="price" class="error" /> </p>
		<!-- ONLY ALLOW POSTIVE WHOLE NUMBER JS:
		onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" 
		 -->
		<p>&emsp;<input type=submit value="Edit" />&emsp;<input type="reset" value="Clear"/> </p>
	</form:form>
	
	<p>&emsp;<a class="text-danger" href="${pageContext.request.contextPath}/deleteItem?itemId=${item.itemId}">Delete Item</a> <p>
	
	<p>&emsp;<a href="${pageContext.request.contextPath}/showSetup">Return to Setup</a> </p>
</body>
</html>