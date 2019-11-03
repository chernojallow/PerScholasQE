<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.time.LocalDateTime, java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selenium Locators</title>
</head>
<body>
	<header>
		<h1 id="pageTitle">Selenium Locators Demonstration Page</h1>
		<h2>Run tests on these elements using Selenium locators</h2>
	</header>
	<form action="${pageContext.request.contextPath}/index" method="post">
		<label>Please enter your name: <input name="userName" /></label>
		<input name="submit" type="submit" value="Submit"/>
	</form>
	<div id="div1" class="divClass">
		<c:if test="${userName != null }">
			<h2 id="welcomeMessage">Welcome ${userName}!</h2>
		</c:if>
		<p id="dateTime">Today's date and time is 
			${LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a"))}
		</p>
	</div>
	<div id="div2" class="divClass">
		<h1>Courses</h1>
		<table>
			<thead>
				<tr>
					<th>Code</th>
					<th>Name</th>
					<th>Location</th>
					<th>Maximum Size</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>ASM</td>
					<td class="courseName">Application Support Management</td>
					<td>Dallas</td>
					<td>25</td>
				</tr>
				<tr>
					<td>DE</td>
					<td class="courseName">Data Engineering</td>
					<td>Irving</td>
					<td>30</td>
				</tr>
				<tr>
					<td>QEA</td>
					<td class="courseName">Quality Engineering &amp; Assurance</td>
					<td>Dallas</td>
					<td>30</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>