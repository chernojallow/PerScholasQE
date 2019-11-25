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
				<c:set var="catId" value="${category.categoryId}" scope="page"/>
				<tr>
					<th>&emsp;ID=${catId}</th>
					<th>&emsp;${category.categoryName}</th>
					<td>
						<!-- Items -->
						<table>
							<c:forEach items="${allItems}" var="item">
								<c:set var="itemCatId" value="${item.categoryId}" scope="page"/>
								<c:choose>
									<c:when test="${itemCatId == catId}">
										<tr>
											<td>&emsp;&emsp;${item.itemName}</td>
											<td>&emsp;&emsp;${item.price}</td>
										</tr>
									</c:when>
								</c:choose>
							</c:forEach>
						</table>
						<!-- End of items -->
						
					</td>
				</tr>
			</c:forEach>
			
	</table>
	
<%-- 	<table>
				<tr>
					<th>&emsp;Username</th>
					<th>&emsp;Role</th>
					<th>&emsp;<a href="${pageContext.request.contextPath}/showAddSubuser">Add</a></th>
				</tr>
				
				<c:forEach items="${subusers}" var="subuser">
					<c:choose>
						<c:when test="${currentUser.role < subuser.role}">
							<tr>
								<td>&emsp;${subuser.username}</td>
								<td>
									<c:choose>
										<c:when test="${subuser.role == 2}">
											&emsp;Manager
										</c:when>
										<c:otherwise>
											&emsp;Waiter/Waitress
										</c:otherwise>
									</c:choose>
								</td>
								<td>&emsp;<a href="${pageContext.request.contextPath}/deleteSubuser?userId=${subuser.userId}">Delete</a></td>
							</tr>
						</c:when>
					</c:choose>
				</c:forEach>
			</table>	 --%>
	
</body>
</html>