<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
	<h1>Books</h1>
	<fieldset>
		<legend>Book Form</legend>
		<form:form action="${pageContext.request.contextPath}/addBook" method="post" modelAttribute="book">
			<div>
				<label for="title">Title</label>
				<div>
					<form:input path="title"/>
					<p style="color:red;"><form:errors path="title" class="error"/></p>
				</div>
			</div>
			<div>
				<label for="author">Author</label>
				<div>
					<form:input path="author"/>
					<p style="color:red;"><form:errors path="author" class="error"/></p>
				</div>
			</div>
			<input type="submit" value="Add Book" />
		</form:form>
	</fieldset>
	<fieldset>
		<legend>Book List</legend>
		<table>
			<tr>
				<th>Book ID</th>
				<th>Title</th>
				<th>Author</th>
			</tr>
			<c:forEach items="${allBooks}" var="book">
				<tr>
					<td>${book.bookId}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td><a href="${pageContext.request.contextPath}/removeBook/${book.bookId}">Remove Book</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>