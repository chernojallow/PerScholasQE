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

    <form name="login" method="POST" action="HomeServlet">
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