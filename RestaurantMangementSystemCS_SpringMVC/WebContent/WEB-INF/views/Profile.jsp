<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Profile</title>
</head>
<body>
	<h1>${currentUser.username} Profile</h1>
	<p> <%@ include file="Navigation.html" %> </p>
	
	<h2>Username: ${currentUser.username}</h2>
	
	<c:choose>
		<c:when test="${currentUserAddress.address2 == '' || currentUserAddress.address2 == null}">
			<h2>Address: ${currentUserAddress.address1}, ${currentUserAddress.city}, ${currentUserAddress.state} ${currentUserAddress.postalCode}</h2>
		</c:when>
		<c:otherwise>
			<h2>Address: ${currentUserAddress.address1}, ${currentUserAddress.address2}, ${currentUserAddress.city}, ${currentUserAddress.state} ${currentUserAddress.postalCode}</h2>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${currentUser.role == 1}">
			<h2>Role: Owner</h2>
		</c:when>
		<c:when test="${currentUser.role == 2}">
			<h2>Role: Manager</h2>
		</c:when>
		<c:otherwise>
			<h2>Role: Waiter/Waitress</h2>
		</c:otherwise>
	</c:choose>
	
	<a href="${pageContext.request.contextPath}/showChangePassword">Change Password</a>
	
	<c:choose>
		<c:when test="${currentUser.role <= 2}">
			<br><br>
			<h3>Subusers</h3>	
			
			<table>
				<tr>
					<th>Username</th>
					<th>Role</th>
					<th><a href="${pageContext.request.contextPath}/showAddSubuser">Add</a></th>
				</tr>
				
				<c:forEach items="${subusers}" var="subuser">
					<c:choose>
						<c:when test="${currentUser.role < subuser.role}">
							<tr>
								<td>${subuser.username}</td>
								<td>
									<c:choose>
										<c:when test="${subuser.role == 2}">
											Manager
										</c:when>
										<c:otherwise>
											Waiter/Waitress
										</c:otherwise>
									</c:choose>
								</td>
								<td><a href="${pageContext.request.contextPath}/deleteSubuser?userId=${subuser.userId}">Delete</a></td>
							</tr>
						</c:when>
					</c:choose>
				</c:forEach>
			</table>	
		</c:when>
	</c:choose>
</body>
</html>