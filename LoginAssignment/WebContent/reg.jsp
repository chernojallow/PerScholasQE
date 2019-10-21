<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
</head>
<body>
	<header>
		<h1>Create Account</h1>
	</header>

    <form name="register" method="POST" action="RegServlet">
        <label for="Name">Name:
            <input type="text" name="Name"/>
        </label>

        <br/><br/>
        
        <label for="Email">Email:
            <input type="text" name="Email" />
        </label>

        <br/><br/>
        <label for="DOB">DOB:
            <input type="date" name="DOB" />
        </label>
        
        <br/><br/>
        <span>Gender: </span>
        <label>
            <br/>
            <input type="radio" name="Gender" value="Female">Female
        </label>
        
        <label>
        	<input type="radio" name="Gender" value="Male">Male
        </label>
        
        <label>
        	<input type="radio" name="Gender" value="Other">Other
        </label>
            
        <br/><br/>
        <label for="Username">Username:
            <input type="text" name="Username" />
        </label>

        <br/><br/>
        <label for="Password">Password:
                <input type="password" name="Password" />
        </label>

        <br/><br/>
        <label for="Confirm Password">Confirm Password:
            <input type="password" name="ConfirmPassword" />
        </label>

        <br/><br/>
        <input type="submit" value="Register"/>
        <input type="reset" value="Clear" />
    </form>

</body>
</html>