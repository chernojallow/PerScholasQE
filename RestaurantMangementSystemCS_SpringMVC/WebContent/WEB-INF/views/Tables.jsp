<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style> input[type=number] {width: 35px;}</style>
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
		&emsp;&emsp;&emsp;&emsp;
		<c:choose>
			<c:when test="${table.orderId == 0}">
				<button style="height:150px; width:150px; font-size:30px;" class="btn btn-primary" data-toggle="modal" data-target="#addOrder${table.tableId}">Table ${table.tableId}</button>
			
				<div class="modal fade" id="addOrder${table.tableId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">		
						<div class="modal-content">
							<form:form action="${pageContext.request.contextPath}/addOrder/${table.tableId}" method="post">
							
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Add Order ${table.tableId}</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								
								<div class="modal-body">
									<c:forEach items="${allCategories}" var="category">
										<c:set var="categoryId" value="${category.categoryId}" scope="page"/>
										<div>&emsp;<p><b>${category.categoryName}</b></p>
											<c:forEach items="${allItems}" var="item">
												<c:if test="${item.categoryId == categoryId}">
													<p align="center">${item.itemName}&emsp;&emsp;&emsp;&emsp;$${item.price}&emsp;&emsp;&emsp;&emsp;
														Quantity:&nbsp;<input name="${itemName}nbr" type="number" value="0" min="0" step="1" required/></p>
												</c:if>
											</c:forEach>
										</div>
									</c:forEach>
					      		</div>
					      		
								<div class="modal-footer">
									<input type=submit value="Add Order" class="btn btn-primary"/>
									<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								</div>
							
							</form:form>
						</div>
					</div>
				</div>
			
			</c:when>
			<c:otherwise>
				<button style="height:150px; width:150px; font-size:30px;" class="btn btn-primary" data-toggle="modal" data-target="#viewOrder${table.tableId}">Table ${table.tableId}</button>
				
				<div class="modal fade" id="viewOrder${table.tableId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">View Order ${table.tableId}</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							
							<div class="modal-body">
								<p>View Order</p>
				      		</div>
				      		
							<div class="modal-footer">
								<button type="button" class="btn btn-primary">OK</button>
								<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</body>
</html>