<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ads</title>
</head>
<body>
	<h1>Ads</h1>
	
	<fieldset>
		<legend>Ad Form</legend>
		<form:form action="${pageContext.request.contextPath}/addAd" method="post" modelAttribute="ad">
			<div>
				<label for="name">Name</label>
				<div>
					<form:input path="name"/>
					<p style="color:red;"><form:errors path="name" class="error"/></p>
				</div>
			</div>
			<div>
				<label for="price">Price</label>
				<div>
					<form:input path="price"/>
					<p style="color:red;"><form:errors path="price" class="error"/></p>
				</div>
			</div>
			<input type="submit" value="Add Ad" />
		</form:form>
	</fieldset>
	
	<fieldset>
		<legend>Ad List</legend>
		<table>
			<tr>
				<th>Ad ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Status</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${allAds}" var="ad">
				<tr>
					<td>${ad.adId}</td>
					<td>${ad.name}</td>
					<td>${ad.price}</td>
					<td>${ad.status}</td>
					<td>
						<c:choose>
							<c:when test="${ad.getStatus().equals(\"Sold\")}">
								<a href="${pageContext.request.contextPath}/cancelAd/${ad.adId}">Cancel</a>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/orderAd/${ad.adId}">Order</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>