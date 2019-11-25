<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Profile</title>
</head>
<body>
	<h1>&emsp;${currentUser.username}'s Profile</h1>
	<p>&emsp;<%@ include file="Navigation.jsp" %> </p>
	
	<h2>&emsp;Username: ${currentUser.username}</h2>
	
	<c:choose>
		<c:when test="${currentUserAddress.address2 == '' || currentUserAddress.address2 == null}">
			<h2>&emsp;Address: ${currentUserAddress.address1}, ${currentUserAddress.city}, ${currentUserAddress.state} ${currentUserAddress.postalCode}</h2>
		</c:when>
		<c:otherwise>
			<h2>&emsp;Address: ${currentUserAddress.address1}, ${currentUserAddress.address2}, ${currentUserAddress.city}, ${currentUserAddress.state} ${currentUserAddress.postalCode}</h2>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${currentUser.role == 1}">
			<h2>&emsp;Role: Owner</h2>
		</c:when>
		<c:when test="${currentUser.role == 2}">
			<h2>&emsp;Role: Manager</h2>
		</c:when>
		<c:otherwise>
			<h2>&emsp;Role: Waiter/Waitress</h2>
		</c:otherwise>
	</c:choose>
	
	<p>&emsp;&emsp;<a href="${pageContext.request.contextPath}/showChangePassword">Change Password</a> </p>
	
	<c:choose>
		<c:when test="${currentUser.role <= 2}">
			<br><br>
			<h3>&emsp;Subusers</h3>	
			
			<table>
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
			</table>	
		</c:when>
	</c:choose>
</body>
</html>