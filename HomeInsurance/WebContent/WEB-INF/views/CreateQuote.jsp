<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Quote</title>
</head>
<body style="text-align:center;">
	<h1>Create Quote</h1>
	<form action="${pageContext.request.contextPath}/HomeServlet/createHome" method="post">
		<p> <label>Address1:&nbsp;<input name="addr1" required/> </label> </p>
		<p> <label>Address2:&nbsp;<input name="addr2"/> </label> </p>
		<p> <label>City:&nbsp;<input name="city" required/> </label> </p>
		<p> <label>State:&nbsp;<input name="state" required/> </label> </p>
		<p> <label>Zip Code:&nbsp;<input type="number" name="zipCode" required/> </label> </p>
		<p> <label>Year Built:&nbsp;<input type="number" name="yearBuilt" required/> </label> </p>
		<p> <label>Home Value:&nbsp;<input type="number" step="0.01" name="homeValue" required/> </label> </p>
		<p> <input type="submit" value="Submit" /> <input type="reset"/></p>
	</form>
	<a href="${pageContext.request.contextPath}/HomeServlet/showWelcomePage">Return to Welcome Page</a>
</body>
</html>