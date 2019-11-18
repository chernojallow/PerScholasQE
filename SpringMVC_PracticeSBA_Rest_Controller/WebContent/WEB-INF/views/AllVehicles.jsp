<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Vehicles</title>
</head>
<body>
	<h1>All Vehicles</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Type</th>
		</tr>
		<c:forEach items="${allVehicles.values()}" var = "vehicle" >
			<tr>
				<td>${vehicle.vehicleId}</td>
				<td>${vehicle.make}</td>
				<td>${vehicle.model}</td>
				<td>&emsp;&emsp;Color: 
					<c:forEach items = "${vehicle.colors}" var = "color">
						${color}
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>