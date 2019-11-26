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
	<p>&emsp;<%@ include file="Navigation.jsp" %> </p>
	
	<h3>&emsp;Number of Tables: ${nbrOfTables}</h3>
	<form action="${pageContext.request.contextPath}/editTables" method="post">
		<p> <label>&emsp;Change Number of Tables:&nbsp;<input name="tables" type="number" required="required"/> </label> </p>
		<p>&emsp;<input type=submit value="Apply" />
	</form>
	
	<!-- Categories -->
	<table>
		<tr>
			<th>&emsp;Items</th>
			<th>&emsp;<a href="${pageContext.request.contextPath}/showAddCategory">Add Category</a></th>
			
			<c:forEach items="${allCategories}" var="category">
				<c:set var="categoryId" value="${category.categoryId}" scope="page"/>
				<tr>
					<th>&emsp;${category.categoryName}</th>
					<td>
						<!-- Items -->
						<table>
							<c:forEach items="${allItems}" var="item">
								<c:set var="itemCatId" value="${item.categoryId}" scope="page"/>
								<c:choose>
									<c:when test="${itemCatId == categoryId}">
										<tr>
											<td>&emsp;${item.itemName}</td>
											<td>&emsp;&emsp;$${item.price}</td>
											<td>&emsp;<a href="${pageContext.request.contextPath}/showEditItem?itemId=${item.itemId}">Edit</a></td>
										</tr>
									</c:when>
								</c:choose>
							</c:forEach>
							
							<tr>
								<th>&emsp;<a href="${pageContext.request.contextPath}/showAddItem?categoryId=${categoryId}">Add Item</a></th>
							</tr>
						</table>
						<!-- End of items -->
					</td>
					
					<th>&emsp;<a href="${pageContext.request.contextPath}/showEditCategory?categoryId=${categoryId}">Edit Category</a> </th>
					
				</tr>
			</c:forEach>
			
	</table>
</body>
</html>