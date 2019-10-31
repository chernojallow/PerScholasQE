<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<header> <h1>Create Account</h1> </header>
	
	<% if (request.getAttribute("regError") != null) {%>
	    <p style="color: red;"><%= request.getAttribute("regError") %></p>
	<% } %>
	
    <form action="${pageContext.request.contextPath}/HomeServlet" method="POST">
        <p> <label>First Name:&nbsp;<input type="text" name="regFirstName" required/> </label> </p>
        
        <p> <label>Last Name:&nbsp;<input type="text" name="regLastName" required/> </label> </p>

        <p> <label>Email:&nbsp;<input type="text" name="regEmail" required/> </label> </p>

        <p> <label>DOB:&nbsp;<input type="date" name="regDOB" required/> </label> </p>
            
        <p> <label>Username:&nbsp;<input type="text" name="regUsername" required/> </label> </p>

        <p> <label>Password:&nbsp;<input type="password" name="regPassword" required/> </label> </p>

        <p> <label>Confirm Password:<input type="password" name="regConfirmPassword" required/> </label> </p>

        <p> <input type="submit" name="register" value="Register"/>
        <input type="reset" value="Clear" /> </p>
    </form>
</body>
</html>