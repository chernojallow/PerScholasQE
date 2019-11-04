<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events Page</title>
</head>
<body>
	<h1>Events Page</h1>
	<%@ include file="Navigation.html" %>
	<form action = "${pageContext.request.contextPath}/HomeServlet/createEvent">
		<div>
			<label>Event Title:</label>
			<input name="title" />
		</div>
		<div>
			<label>Event Description</label>
			<input name="description" />
		</div>
		<div>
			<label>Event Location:</label>
			<input name="location" />
		</div>
		<div>
			<label>Date &amp; Time:</label>
			<input type="datetime-local" name="dateTime" />
		</div>
		<div>
			<input type="submit" value="Create Event" />
		</div>
	</form>
	
	<table>
		<tr>
			<th>Title</th>
			<th>Description</th>
			<th>Location</th>
			<th>Date and Time</th>
		</tr>
		<c:forEach items="${allEvents}" var="event">
			<tr>
				<td>${event.title}</td>
				<td>${event.description}</td>
				<td>${event.location}</td>
				<td>${event.dateTime}</td>
				<td>
					<c:choose>
						<c:when test = "${currentMember.memberId == event.memberId}">
			            	<a href="#">Delete</a>
			         	</c:when>
						<c:otherwise>
						
							<a href="#">Signup/Cancel</a>
						
						</c:otherwise>
		      		</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>