<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alert Page</title>
	<script>
		function loadOnClick() {
			alert("Alert Message!");
		}
		function promptUser() {
			var person = prompt("Please enter your name", "Your Name");
			document.getElementById("welcomeMessage").innerHTML = "Welcome " + person + "!";
		}
	</script>
</head>
<body onload="promptUser()">
	<h1>Alert Page</h1>
	<%@ include file="Header.jsp" %>
	<button onclick="loadOnClick()">Message</button>
	
	<h2 id="welcomeMessage">Welcome Message</h2>
	
</body>
</html>