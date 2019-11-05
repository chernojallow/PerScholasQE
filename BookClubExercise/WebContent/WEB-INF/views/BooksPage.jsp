<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Page</title>
</head>
<body>
	<h1>Books Page</h1>
	<%@ include file="Navigation.html" %>
	<form action = "${pageContext.request.contextPath}/HomeServlet/createBook">
		<p> <label>Book Title:&nbsp;<input name="title" required/> </label> </p>
		<p> <label>Book Synopsis:&nbsp;<input name="synopsis" required/> </label> </p>
		<p> <label>Book Author:&nbsp;<input name="author" required/> </label> </p>
		<p> <label>Date:&nbsp;<input type="date" name="pDate" required/></label>
		<p> <input type="submit" value="Create Book"/> <input type="reset"/> </p>
	</form>
	<table>
		<tr>
			<th>Title</th>
			<th>Synopsis</th>
			<th>Author</th>
			<th>Publication Date</th>
		</tr>
		<c:forEach items="${bookList}" var="book">
			<tr>
				<td>${book.title}</td>
				<td>${book.synopsis}</td>
				<td>${book.author}</td>
				<td>${book.pDate}</td>
				<td>
					<c:choose>
						<c:when test = "${currentMember.memberID == book.memberID}">
			            	<a href="#">Delete</a>
			         	</c:when>
						<c:otherwise>
							<a href="#">CheckOut</a>
						</c:otherwise>
		      		</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>