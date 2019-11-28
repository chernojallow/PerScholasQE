<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Tables</title>
</head>
<body>
	<h1>&emsp;Tables</h1>
	<p>&emsp;<%@ include file="Navigation.jsp" %> </p>	
	
	<c:forEach items="${allTables}" var="table">
		&emsp;&emsp;
		<c:choose>
			<c:when test="${table.orderId == -1}">
				<button style="height:150px; width:150px; font-size:30px;" class="btn btn-primary" data-toggle="modal" data-target="#addOrder">Table ${table.tableId}</button>
			</c:when>
			<c:otherwise>
				<button style="height:150px; width:150px; font-size:30px;" class="btn btn-primary" data-toggle="modal" data-target="#viewOrder">Table ${table.tableId}</button>
			</c:otherwise>
		</c:choose>
		&emsp;&emsp;
	</c:forEach>
	
	<div class="modal fade" id="addOrder" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add Order</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				
				<div class="modal-body">
					Body Content
	      		</div>
	      		
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">Add Order</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="viewOrder" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add Order</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				
				<div class="modal-body">
					Body Content
	      		</div>
	      		
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">OK</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>