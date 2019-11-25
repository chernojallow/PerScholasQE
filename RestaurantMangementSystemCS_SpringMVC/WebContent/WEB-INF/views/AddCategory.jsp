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
<title>Add Category</title>
</head>
<body>
	<h1>&emsp;Add Category</h1>
	<p>&emsp;<%@ include file="Navigation.jsp" %> </p>
	
	<form:form action="${pageContext.request.contextPath}/addCategory" method="post" modelAttribute="category">
		<fieldset>
			<%-- <form:input path="categoryId" type="hidden" value="-1"/> --%>
			
			<p> <label>&emsp;Category Name:&nbsp;<form:input path="categoryName" placeholder="name" required="required"/> </label> </p>
			<p> <form:errors path="categoryName" class="error" /> </p>
			
			<p>&emsp;<input type=submit value="Add" />&emsp;<input type="reset" value="Clear"/> </p>
		</fieldset>
	</form:form>
	
	<p>&emsp;<a href="${pageContext.request.contextPath}/showSetup">Return to Setup</a> </p>
</body>
</html>