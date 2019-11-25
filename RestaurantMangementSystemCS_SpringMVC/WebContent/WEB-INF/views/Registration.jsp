<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	.error {color: red;}
</style>
<title>Registration Page</title>
</head>
<body>
	<h1>&emsp;Registration Page</h1>
	<p class="error">${errorMessage}</p>
	
	<form:form action="${pageContext.request.contextPath}/registerUser" method="post" modelAttribute="registration">
		<fieldset>
			<p> <label>&emsp;Username:&nbsp;<form:input path="username" placeholder="username123" required="required"/> </label> </p>
			<p> <form:errors path="username" class="error" /> </p>
			
			<p> <label>&emsp;Password:&nbsp;<form:input path="password" type="password" placeholder="password123" required="required" /> </label> </p>
			<p> <form:errors path="password" class="error" /> </p>
			
			<p> <label>&emsp;Address 1:&nbsp;<form:input path="address1" placeholder="100 Address St." required="required"/></label> </p>
			<p> <form:errors path="address1" class="error" /> </p>
			
			<p> <label>&emsp;Address 2:&nbsp;<form:input path="address2" placeholder="Apt 111"/></label> </p>
			<p> <form:errors path="address2" class="error" /> </p>
			
			<p> <label>&emsp;City:&nbsp;<form:input path="city" placeholder="City" required="required"/></label> </p>
			<p> <form:errors path="city" class="error" /> </p>
			
			<p> <label>&emsp;State:&nbsp;<form:select path="state">
				<option value="AL">Alabama</option>
				<option value="AK">Alaska</option>
				<option value="AZ">Arizona</option>
				<option value="AR">Arkansas</option>
				<option value="CA">California</option>
				<option value="CO">Colorado</option>
				<option value="CT">Connecticut</option>
				<option value="DE">Delaware</option>
				<option value="FL">Florida</option>
				<option value="GA">Georgia</option>
				<option value="HI">Hawaii</option>
				<option value="ID">Idaho</option>
				<option value="IL">Illinois</option>
				<option value="IN">Indiana</option>
				<option value="IA">Iowa</option>
				<option value="KS">Kansas</option>
				<option value="KY">Kentucky</option>
				<option value="LA">Louisiana</option>
				<option value="ME">Maine</option>
				<option value="MD">Maryland</option>
				<option value="MA">Massachusetts</option>
				<option value="MI">Michigan</option>
				<option value="MN">Minnesota</option>
				<option value="MS">Mississippi</option>
				<option value="MO">Missouri</option>
				<option value="MT">Montana</option>
				<option value="NE">Nebraska</option>
				<option value="NV">Nevada</option>
				<option value="NH">New Hampshire</option>
				<option value="NJ">New Jersey</option>
				<option value="NM">New Mexico</option>
				<option value="NY">New York</option>
				<option value="NC">North Carolina</option>
				<option value="ND">North Dakota</option>
				<option value="OH">Ohio</option>
				<option value="OK">Oklahoma</option>
				<option value="OR">Oregon</option>
				<option value="PA">Pennsylvania</option>
				<option value="RI">Rhode Island</option>
				<option value="SC">South Carolina</option>
				<option value="SD">South Dakota</option>
				<option value="TN">Tennessee</option>
				<option value="TX">Texas</option>
				<option value="UT">Utah</option>
				<option value="VT">Vermont</option>
				<option value="VA">Virginia</option>
				<option value="WA">Washington</option>
				<option value="WV">West Virginia</option>
				<option value="WI">Wisconsin</option>
				<option value="WY">Wyoming</option>
			</form:select> </label> <p>
			<p> <form:errors path="state" class="error" /> </p>
			
			<p> <label>&emsp;Zip Code:&nbsp;<form:input path="postalCode" type="number" placeholder="12345" required="required"/> </label> </p>
			<p> <form:errors path="postalCode" class="error" /> </p>
			
			<p>&emsp;<input type=submit value="Register" />&emsp;<input type="reset" value="Clear"/> </p>
		</fieldset>
	</form:form>
	<p>&emsp;<a href="${pageContext.request.contextPath}/login">Return to login</a> </p>
</body>
</html>