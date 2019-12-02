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
<title>Edit ${category.categoryName} Category</title>
</head>
<body>
	<h1>&emsp;Edit ${category.categoryName} Category</h1>
	<p>&emsp;<%@ include file="Navigation.jsp" %> </p>
	
	<form:form action="${pageContext.request.contextPath}/editCategory" method="post" modelAttribute="newCategory">
		<form:input path="categoryId" type="hidden" value="${category.categoryId}"/>
		<form:input path="addressId" type="hidden" value="${currentUser.addressId}"/>
		
		<p> <label>&emsp;Category Name:&nbsp;<form:input path="categoryName" placeholder="name" required="required" value="${category.categoryName}"/> </label> </p>
		<p> <form:errors path="categoryName" class="error" /> </p>
			
		<p>&emsp;<input type=submit value="Edit" />&emsp;<input type="reset" value="Clear"/> </p>
	</form:form>
	
	<p>&emsp;<a class="text-danger" href="${pageContext.request.contextPath}/deleteCategory?categoryId=${category.categoryId}">Delete Category</a> <p>
	
	<p>&emsp;<a href="${pageContext.request.contextPath}/showSetup">Return to Setup</a> </p>
</body>
</html>