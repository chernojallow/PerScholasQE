<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bookstore Page</title>
<style>
	#book_list {
		margin: 10px;
		border: 5px solid #333333;
		background-color: #cccccc;
		width: 90%;
		height: auto;
	}
	.book_item {
		vertical-align: top;
		display: inline-block;
		margin: 10px;
		border: 3px solid black;
		background-color: #aaaaaa;
		width: 150px;
		height: 200px;
	}
	
	input[value="Add Item"]:hover  {
		background-color: black;
		color: white;
	}
	
	.book_title {
		width: 95%;
		height: 50%;
		margin: auto;
		border: 2px solid black;
	}
	
	.book_title > p {
		margin-left: 10px;
	}
	
</style>
</head>
<body>
	<h1>Bookstore</h1>
	<%@ include file="Header.jsp" %>
	<div id="book_list">
		<form id="book1" class="book_item" action="addToCart" method="POST">
			<div class="book_title">
				<p>SQL for Java Developers</p>
			</div>
			<div class="book_purchase">
				<div class="book_price">
					<p>$12.99</p>
				</div>
				<div class="add_button">
					<input type="hidden" name="price" value="12.99" />
					<input type="hidden" name="title" value="SQL for Java Developers" />
					<input id="book1Add" type="submit" value="Add Item"/>
				</div>
			</div>
		</form>
		
		<form id="book2" class="book_item" action="addToCart" method="POST">
			<div class="book_title">
				<p>Java Projects</p>
			</div>
			<div class="book_purchase">
				<div class="book_price">
					<p>$14.99</p>
				</div>
				<div class="add_button">
					<input type="hidden" name="price" value="14.99" />
					<input type="hidden" name="title" value="Java Projects" />
					<input id="book2Add" type="submit" value="Add Item"/>
				</div>
			</div>
		</form>
		<form id="book3" class="book_item" action="addToCart" method="POST">
			<div class="book_title">
				<p>Testing Spring MVC Projects</p>
			</div>
			<div class="book_purchase">
				<div class="book_price">
					<p>$21.99</p>
				</div>
				<div class="add_button">
					<input type="hidden" name="price" value="21.99" />
					<input type="hidden" name="title" value="Testing Spring MVC Projects" />
					<input id="book3Add" type="submit" value="Add Item"/>
				</div>
			</div>
		</form>
		<div>
			<p>Shopping Cart</p>
			<table>
				<tr>
					<th>Title</th>
					<th>Price</th>
				</tr>
				<c:forEach items="${bookCart}" var="book" >
					<tr>
						<td>${book.title}</td>
						<td>${book.price}</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<p id="cart_total">Cart Total: ${cartTotal}</p>
			</div>
			<div>
				<form action="placeOrder" method="POST">
					<input type="submit" value="Place Order" />
				</form>
			</div>
			<div>
				<form action="clearShoppingCart" method="POST">
					<input type="submit" value="Clear Cart"/>
				</form>
			</div>
		</div>
	</div>

</body>
</html>