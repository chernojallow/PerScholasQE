<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<header>
	<h1>Sign in</h1>
    </header>
    
    <%--request.getAttribute("Username"); --%>
	<%request.getAttribute("Password"); %>
	<%request.getAttribute("Email"); %>
	<%request.getAttribute("Gender"); %>
	<%request.getAttribute("Name"); %>
	
	<input type="text" name="regUsername" value="<%request.getAttribute("regUsername"); %>">

    <form name="login" method="POST" action="LoginServlet">
        <br/><br/>
        <label for="Username">Username:                
            <input type="text" name="Username" />
        </label>

        <br/><br/>
        <label for="Password">Password:                
            <input type="password" name="Password" />
        </label>

        <br/><br/>
        <input type="submit" value="Log in" />
        <input type="reset" value="Clear" />
    </form>
</body>
</html>