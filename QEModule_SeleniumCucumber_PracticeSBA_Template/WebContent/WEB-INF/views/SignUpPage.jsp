<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>Sign-up Page</h1>
	<%@ include file="Header.jsp" %>
	<form id="signup_form" action="signUp" method="POST">
		<div>
			<label>Name:</label>
			<input id="name_input" type="text" name="name" />
		</div>
		<div>
			<label>Email:</label>
			<input id="email_input" type="text" name="email" />
		</div>
		<div>
			<label>Password:</label>
			<input id="password_input" type="text" name="password" />
		</div>
		<div>
			<label>Location:</label>
				<input class="location_input" type="radio" name="location" value="Dallas" />
				<label>Dallas</label>

				<input class="location_input" type="radio" name="location" value="Irving" />
				<label>Irving</label>
		</div>
		<div>
			<label>Course:</label>
			<select id="course_select" name="course">
				<option value="Application Support Management">Application Support Management</option>
				<option value="Quality Engineering & Assurance">Quality Engineering &amp; Assurance</option>
				<option value="Data Engineering">Data Engineering</option>
			</select>
		</div>
		<div>
			<label>Languages:</label>
			<input class="languages" type="checkbox" name="languages1" value="C#" />
			<label>C#</label>
			<input class="languages" type="checkbox" name="languages2" value="Java" />
			<label>Java</label>
			<input class="languages" type="checkbox" name="languages3" value="Python" />
			<label>Python</label>
			<input class="languages" type="checkbox" name="languages4" value="Swift" />
			<label>Swift</label>
		</div>
		<div>
			<label>What date can you start?</label>
			<input id="startdate_input" type="date" name="startDate" />
		</div>
		<div>
			<input type="submit" value="Submit" />
		</div>
	</form>
</body>
</html>