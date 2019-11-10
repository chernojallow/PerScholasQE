<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation Page</title>
</head>
<body>
	<h1>Thanks for your business!</h1>
	<h2>One of our customer representatives will will</h2>
	<h2>reach out to you soon to activate your</h2>
	<h2>home insurance policy.</h2>
	
	<form action="${pageContext.request.contextPath}/HomeServlet/showWelcomePage" method="post">
		<p> <input type="submit" name="welcomePage" value="Back to Welcome Page" /> </p>
	</form>
</body>
</html>