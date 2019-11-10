SET FOREIGN_KEY_CHECKS=0;
USE `unit_testing6`;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
	`productID` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL,
	`price` Double NOT NULL,
	PRIMARY KEY (`productID`)
) DEFAULT CHARSET=UTF8;


INSERT INTO product VALUES ('1', 'gum', '1.25');
INSERT INTO product (`productID`, `name`, `price`) VALUES ('2', 'chips', '2.50');

/*
SELECT * FROM product;
SELECT * FROM product WHERE `productID` = '1';
SELECT * FROM product WHERE `name` = 'chips';
*/