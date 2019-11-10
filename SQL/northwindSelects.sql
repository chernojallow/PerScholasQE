SELECT * FROM categories;

SELECT * FROM employees
WHERE Country="USA";

SELECT TitleOfCourtesy, FirstName, LastName, City, Region, Country 
FROM employees WHERE TitleOfCourtesy = "Ms." OR TitleOfCourtesy = "Mrs.";

SELECT TitleOfCourtesy, FirstName, LastName, City, Region, Country 
FROM employees WHERE TitleOfCourtesy = "Mr.";

SELECT TitleOfCourtesy, FirstName, LastName, City, Region, Country 
FROM employees WHERE TitleOfCourtesy = "Dr.";

SELECT * FROM customers
WHERE Region IS NOT NULL;

SELECT * FROM customers
WHERE Region IS NULL;

SELECT * FROM orders
WHERE Freight BETWEEN 250 and 500;

/* Starts with A*/
SELECT * FROM suppliers
WHERE CompanyName LIKE "A%";

/* End with A*/
SELECT * FROM suppliers
WHERE CompanyName LIKE "%A";

/* Only Common */
SELECT * FROM `order details` INNER JOIN orders
ON `order details`.OrderID = orders.OrderID;

/* Left Table and Common */
SELECT orders.OrderID, orders.ShipVia, orders.CustomerID, orders.ShipName 
FROM orders LEFT JOIN shippers 
ON orders.ShipVia = shippers.ShipperID;

/* Right Table and Common */
SELECT orders.OrderID, orders.ShipVia, orders.CustomerID, orders.ShipName 
FROM orders RIGHT JOIN shippers 
ON orders.ShipVia = shippers.ShipperID;

/* Same as Left Join */
SELECT products.ProductName, products.QuantityPerUnit, products.UnitPrice
FROM products LEFT OUTER JOIN suppliers
on products.SupplierID = suppliers.SupplierID;

SELECT orders.OrderID, orders.ShipVia, orders.CustomerID, orders.ShipName 
FROM orders LEFT JOIN shippers 
ON orders.ShipVia = shippers.ShipperID
WHERE shippers.ShipperID IS NULL;

/* Same as Right Join */
SELECT ProductName, QuantityPerUnit, UnitPrice
FROM products RIGHT OUTER JOIN suppliers
ON products.SupplierID = suppliers.SupplierID;

/* Full Outer Join Using Cross Join (Everything)*/
SELECT products.ProductName, products.QuantityPerUnit, products.UnitPrice
FROM products CROSS JOIN suppliers
ON products.SupplierID = suppliers.SupplierID;

/* Subquery */
SELECT CustomerID, companyName, ContactName, PostalCode FROM customers
WHERE PostalCode = (SELECT PostalCode FROM customers WHERE PostalCode = '12209');

/* Same as the subquery */
SELECT CustomerID, companyName, ContactName, PostalCode FROM customers
WHERE PostalCode = '12209';

/* Incorrect since WHERE statement wants a condition */
SELECT CustomerID, companyName, ContactName, PostalCode FROM customers
WHERE City IN (SELECT City FROM customers WHERE City = 'London');

/* Get only 1 unique result from subquery */
SELECT DISTINCT Country FROM customers
WHERE City = (SELECT City FROM customers WHERE City = 'London' GROUP BY 'London');

SELECT DISTINCT Country FROM customers
WHERE City IN (SELECT City FROM customers WHERE City = 'London');

SELECT DISTINCT Country FROM customers
WHERE City IN (SELECT City FROM customers WHERE City = 'London' GROUP BY 'London');

SELECT DISTINCT Country FROM customers
WHERE City IN (SELECT City FROM customers WHERE City = 'London' GROUP BY 'London')
GROUP BY Country;

/* 9/30 Class Excercise */
/* Product list of ProductName and UnitInStock */
SELECT ProductName, UnitsInStock FROM products;

/* Product list of ProductID & ProductName for current product */
SELECT ProductID, ProductName FROM products WHERE Discontinued = 0;

/* Product list of ProductID & ProductName for discontinued products */
SELECT ProductID, ProductName FROM products WHERE Discontinued = 1;

/* Product list of ProductName & UnitPrice for most and least expensive products */
SELECT ProductName, UnitPrice FROM products
WHERE UnitPrice = (SELECT MIN(UnitPrice) FROM products) 
OR UnitPrice = (SELECT MAX(UnitPrice) FROM products);

/* Product list of ProductID, ProductName, UnitPrice for current products where UnitPrice is < $20*/
SELECT ProductID, ProductName, UnitPrice FROM products WHERE UnitPrice < '20' AND Discontinued = '0';

/* Product list of ProductId, ProductName, UnitPrice where UnitPrice is between $15 and $25 */
SELECT ProductID, ProductName, UnitPrice FROM products WHERE UnitPrice BETWEEN '15' AND '25';

/* Product list of ProductName & UnitPrice where UnitPrice is greater than average of UnitPrice */
SELECT ProductName, UnitPrice FROM products WHERE UnitPrice > (SELECT AVG(UnitPrice) FROM products);

/* Product list of ProductName & UnitPrice for top 10 UnitPrice in order */
SELECT ProductName, UnitPrice FROM products ORDER BY UnitPrice DESC Limit 10;

/* Count Current and Discontinued products */
SELECT COUNT(CASE Discontinued WHEN 0 THEN 1 END) AS Current, 
COUNT(CASE Discontinued WHEN 1 THEN 1 END) AS Discontinued FROM products;

/* Product list of ProductName, UnitsOnOrder, UnitsInStock) where UnitsInStock < UnitsOnOrder */
SELECT ProductName, UnitsOnOrder, UnitsInStock FROM products WHERE UnitsInStock < UnitsOnOrder;
/* End of 9/30 Excercise */

/* ProductID, ProductName, Supplier Address, City, Region, PostalCode*/
SELECT ProductID, ProductName, s.Address, s.City, 
s.Region, s.PostalCode FROM products p JOIN suppliers s
ON p.SupplierID = s.SupplierID;

/* ProductName, Quantity of product, OrderID, CompanyName */
SELECT DISTINCT products.ProductName, `order details`.Quantity, orders.OrderID, customers.CompanyName
FROM customers JOIN orders ON customers.CustomerID = orders.CustomerID
JOIN `order details` ON orders.OrderID = `order details`.OrderID
JOIN products ON `order details`.ProductID = products.ProductID;

/* OrderID, CompanyName, Order product quantity */
SELECT orders.OrderID, customers.CompanyName, SUM(`order details`.Quantity) AS Quantity
FROM customers JOIN orders ON customers.CustomerID = orders.CustomerID
JOIN `order details` ON orders.OrderID = `order details`.OrderID
JOIN products ON `order details`.ProductID = products.ProductID
GROUP BY orders.OrderID;

/* OrderID, Quantity */
SELECT orders.OrderID, SUM(`order details`.Quantity) AS `Products Ordered`
FROM orders JOIN `order details` ON orders.OrderID = `order details`.OrderID
GROUP BY orders.OrderID;