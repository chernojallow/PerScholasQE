<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1 id="pageTitle">Selenium Locators Demonstration Page</h1>
		<h2>Run tests on these elements using Selenium locators</h2>
	</header>

	<form action="${pageContext.request.contextPath/index}" method="post">
		<label>Please enter your name: <input name="userName" /></label> <input
			name="submit" type="submit" value="Submit" />
	</form>

	<div id="div1" class="divClass">
<%-- 		<c:if test="${userName != null }">
			<h2 id="welcomeMessage">Welcome ${userName}!</h2>
		</c:if> --%>
		<p id="dateTime">Today's date and time is
			${LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a"))}
		</p>
	</div>
</body>
</html>