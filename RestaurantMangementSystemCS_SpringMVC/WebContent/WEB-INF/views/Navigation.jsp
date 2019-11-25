<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<nav>
	&emsp;<a href="${pageContext.request.contextPath}/welcome">Welcome</a>
	&emsp;<a href="${pageContext.request.contextPath}/showTables">Tables</a>
	&emsp;<a href="${pageContext.request.contextPath}/showProfile">Profile</a>
	<c:choose>
		<c:when test="${currentUser.role <= 2}">
			&emsp;<a href="${pageContext.request.contextPath}/showSetup">Setup</a>
		</c:when>
	</c:choose>
	&emsp;<a href="${pageContext.request.contextPath}/logout">Logout</a>
</nav>