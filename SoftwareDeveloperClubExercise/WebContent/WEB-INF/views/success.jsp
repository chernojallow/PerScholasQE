<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.time.*"%>  
<%@page import="java.time.temporal.ChronoUnit"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Page</title>
<%
	String username = null, strDOB = null;

	Cookie[] cookies = request.getCookies();
	for (Cookie c : cookies) {
		if (c.getName().equals("dob"))
			strDOB = c.getValue();
		if (c.getName().equals("username"))
			username = c.getValue();
	}
	
	LocalDate dob = LocalDate.parse(strDOB);
	LocalDate nextBDay = dob.withYear(LocalDate.now().getYear());
	
	if (nextBDay.isBefore(LocalDate.now()) || nextBDay.isEqual(LocalDate.now()))
		nextBDay = nextBDay.plusYears(1);

	Period p = Period.between(LocalDate.now(), nextBDay);
%>
</head>
<body>
	<h1>Welcome <%=username%>! You have successfully logged in.</h1>
	<p>There are
		<%	if(p.getMonths() > 0)
			out.print(p.getMonths() + " month(s) and "); 
			else out.print("");%> 
		<%	out.print(p.getDays() + " day(s) until your birthday!");%></p>
</body>
</html>