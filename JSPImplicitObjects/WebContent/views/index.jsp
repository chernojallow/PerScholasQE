<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Objects</title>
</head>
<body>
	<h1>Implicit Objects Page</h1>
	<% request.setAttribute("name", "John"); %>
	<p>Here is the request attribute "name": <%= request.getAttribute("name") %>.</p>
	<p>This was set in the JSP using the request object's setAttribute method</p>
	<p>and then retrieved with the getAttribute method.</p>
	<p></p>
	<p>Here is a print out of the locale using the response object's getLocale method: 
	<%= response.getLocale() %></p>
</body>
</html>