<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selenium Children</title>
</head>
<body>
 	<header>
		<h1>Selenium CSS Children - Demonstration Page</h1>
		<a href="#">header Link</a>
	</header>
	<div>
		<ul>
			<li>div1 ul1 li1</li>
			<li>div1 ul1 li2</li>
		</ul>
		<ul>
			<li>div1 ul2 li1</li>
			<li>div1 ul2 li2</li>
		</ul>
	</div>
	<div id="div2">
		<div>
			<p class="pClass1">div2 div1 p1</p>
			<p class="pClass2">div2 div1 p2</p>
		</div>
		<div>
			<p class="pClass1 pClass2">div2 div2 p1</p>
			<p class="pClass2">div2 div2 p2</p>
		</div>
	</div>
</body>
</html>