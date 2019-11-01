<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/ProductServlet" method="post">
		Product Name: <input type="text" name="productName">
		Product Description: <input type="text" name ="productDescription">
		<input type="hidden" name="productId">
		<input type="submit" name="submit" value="Submit">
	</form>
	
</body>
</html>