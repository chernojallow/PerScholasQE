CREATE DATABASE IF NOT EXISTS `case_study`; 
USE `case_study`; 
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE if EXISTS `address`;
CREATE TABLE `address` (
	`addressId` INT NOT NULL AUTO_INCREMENT,
	`address1` VARCHAR(255) NOT NULL,
	`address2` VARCHAR(255),
	`city` VARCHAR(50) NOT NULL,
	`state` VARCHAR(50) NOT NULL,
	`postalCode` INT NOT NULL,
	PRIMARY KEY (`addressId`)
) DEFAULT CHARSET=UTF8;

DROP TABLE if EXISTS `user`;
CREATE TABLE `user` (
	`userId` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(25) NOT NULL,
	`password` VARCHAR(25) NOT NULL,
	`addressId` INT NOT NULL,
	`role` TINYINT NOT NULL,
	PRIMARY KEY (`userID`),
	UNIQUE (`username`),
	CONSTRAINT `user_fk_addressId` FOREIGN KEY (`addressId`)
		REFERENCES `address` (`addressId`)
        ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

DROP TABLE if EXISTS `order`;
CREATE TABLE `order` (
	`orderId` INT NOT NULL AUTO_INCREMENT,
	`addressId` INT NOT NULL,
	`start` DATETIME NOT NULL,
	`end` DATETIME DEFAULT NULL,
	PRIMARY KEY (`orderId`),
	CONSTRAINT `order_fk_addressId` FOREIGN KEY (`addressId`)
		REFERENCES `address` (`addressId`)
			ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

DROP TABLE if EXISTS `table`;
CREATE TABLE `table` (
	`tableId` INT NOT NULL,
	`addressId` INT NOT NULL,
	`orderId` INT DEFAULT NULL,
	PRIMARY KEY (`tableId`, `addressId`),
	CONSTRAINT `table_fk_addressId` FOREIGN KEY (`addressId`)
		REFERENCES `address` (`addressId`)
			ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `table_fk_orderId` FOREIGN KEY (`orderId`)
		REFERENCES `order` (`orderId`)
			ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

DROP TABLE if EXISTS `item`;
CREATE TABLE `item` (
	`itemId` INT NOT NULL AUTO_INCREMENT,
	`itemName` VARCHAR(50) NOT NULL,
	`categoryId` INT NOT NULL,
	`addressId` INT NOT NULL,
	`price` DOUBLE NOT NULL,
	PRIMARY KEY (`itemId`),
	CONSTRAINT `item_fk_categoryId` FOREIGN KEY (`categoryId`)
		REFERENCES `category` (`categoryId`)
			ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `item_fk_addressId` FOREIGN KEY (`addressId`)
		REFERENCES `address` (`addressId`)
			ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

DROP TABLE if EXISTS `order_items`;
CREATE TABLE `order_items` (
	`orderId` INT NOT NULL,
	`itemId` INT NOT NULL,
	`quantity` INT NOT NULL,
	`subtotal` DOUBLE NOT NULL,
	PRIMARY KEY (`orderId`, `itemId`),
	CONSTRAINT `oi_fk_orderId`
		FOREIGN KEY (`orderId`) REFERENCES `order` (`orderId`) 
			ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `oi_fk_itemId` FOREIGN KEY (`itemId`)
		REFERENCES `item` (`itemId`)
			ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

DROP TABLE if EXISTS `category`;
CREATE TABLE `category` (
	`categoryId` INT NOT NULL AUTO_INCREMENT,
	`categoryName` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`categoryId`)
) DEFAULT CHARSET=UTF8;

/* address */
INSERT INTO `address` (`address1`, `address2`, `city`, `state`, `postalCode`) VALUES ('901 Brookside St.', '', 'Sweetwater', 'TX', 79556);
INSERT INTO `address` (`address1`, `address2`, `city`, `state`, `postalCode`) VALUES ('5008 Derbyshire Dr.', '', 'McKinney', 'TX', 75070);
INSERT INTO `address` (`address1`, `address2`, `city`, `state`, `postalCode`) VALUES ('5300 Gaston Ave.', 'Apt 117-A', 'Dallas', 'TX', 75214);

/* user */
INSERT INTO `user` (`username`, `password`, `addressId`, `role`) VALUES ('xiaolin996', 'xiaolin996', 1, 1);
INSERT INTO `user` (`username`, `password`, `addressId`, `role`) VALUES ('random1', 'random1', 1, 2);
INSERT INTO `user` (`username`, `password`, `addressId`, `role`) VALUES ('random2', 'random2', 1, 3);
INSERT INTO `user` (`username`, `password`, `addressId`, `role`) VALUES ('chenli123', 'chenli123', 2, 2);
INSERT INTO `user` (`username`, `password`, `addressId`, `role`) VALUES ('xiaolin123', 'xiaolin123', 3, 3);

/* table */
INSERT INTO `table` (`addressId`, `tableId`, `orderId`) VALUES (1, 1, 1);
INSERT INTO `table` (`addressId`, `tableId`) VALUES (1, 2);
INSERT INTO `table` (`addressId`, `tableId`) VALUES (1, 3);
INSERT INTO `table` (`addressId`, `tableId`) VALUES (2, 1);
INSERT INTO `table` (`addressId`, `tableId`) VALUES (2, 2);
INSERT INTO `table` (`addressId`, `tableId`) VALUES (2, 3);
INSERT INTO `table` (`addressId`, `tableId`) VALUES (3, 1);
INSERT INTO `table` (`addressId`, `tableId`) VALUES (3, 2);
INSERT INTO `table` (`addressId`, `tableId`) VALUES (3, 3);

/* category */
INSERT INTO `category` (`categoryName`) VALUES ('category1');
INSERT INTO `category` (`categoryName`) VALUES ('category2');
INSERT INTO `category` (`categoryName`) VALUES ('category3');

/* item */
INSERT INTO `item` (`itemName`, `price`, `categoryId`, `addressId`) VALUES ('item1', 11.11, 1, 1);
INSERT INTO `item` (`itemName`, `price`, `categoryId`, `addressId`) VALUES ('item2', 2.22, 1, 1);
INSERT INTO `item` (`itemName`, `price`, `categoryId`, `addressId`) VALUES ('item3', 33.33, 1, 1);
INSERT INTO `item` (`itemName`, `price`, `categoryId`, `addressId`) VALUES ('item4', 44.44, 2, 2);
INSERT INTO `item` (`itemName`, `price`, `categoryId`, `addressId`) VALUES ('item5', 55.55, 2, 2);
INSERT INTO `item` (`itemName`, `price`, `categoryId`, `addressId`) VALUES ('item6', 6.6, 2, 2);
INSERT INTO `item` (`itemName`, `price`, `categoryId`, `addressId`) VALUES ('item7', 7.77, 3, 3);
INSERT INTO `item` (`itemName`, `price`, `categoryId`, `addressId`) VALUES ('item8', 88.8, 3, 3);
INSERT INTO `item` (`itemName`, `price`, `categoryId`, `addressId`) VALUES ('item9', .99, 3, 3);

/* order_items */
INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) VALUES (1, 1, 1, ROUND((SELECT `price` FROM `item` WHERE `itemId` = 1) * 1, 2));
INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) VALUES (1, 2, 2, ROUND((SELECT `price` FROM `item` WHERE `itemId` = 2) * 2, 2));
INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) VALUES (1, 3, 3, ROUND((SELECT `price` FROM `item` WHERE `itemId` = 3) * 3, 2));
INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) VALUES (2, 4, 1, ROUND((SELECT `price` FROM `item` WHERE `itemId` = 4) * 1, 2));
INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) VALUES (2, 5, 2, ROUND((SELECT `price` FROM `item` WHERE `itemId` = 5) * 2, 2));
INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) VALUES (2, 6, 3, ROUND((SELECT `price` FROM `item` WHERE `itemId` = 6) * 3, 2));
INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) VALUES (3, 7, 1, ROUND((SELECT `price` FROM `item` WHERE `itemId` = 7) * 1, 2));
INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) VALUES (3, 8, 2, ROUND((SELECT `price` FROM `item` WHERE `itemId` = 8) * 2, 2));
INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) VALUES (3, 9, 3, ROUND((SELECT `price` FROM `item` WHERE `itemId` = 9) * 3, 2));
INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) VALUES (4, 9, 3, ROUND((SELECT `price` FROM `item` WHERE `itemId` = 9) * 3, 2));


/* order */
INSERT INTO `order` (`addressId`, `start`, `end`) VALUES (1, CURRENT_TIME, NULL);
INSERT INTO `order` (`addressId`, `start`, `end`) VALUES (1, CURRENT_TIME, CURRENT_TIME);
INSERT INTO `order` (`addressId`, `start`, `end`) VALUES (1, CURRENT_TIME, NULL);
INSERT INTO `order` (`addressId`, `start`, `end`) VALUES (2, CURRENT_TIME, CURRENT_TIME);
INSERT INTO `order` (`addressId`, `start`, `end`) VALUES (2, CURRENT_TIME, NULL);
INSERT INTO `order` (`addressId`, `start`, `end`) VALUES (2, CURRENT_TIME, CURRENT_TIME);
INSERT INTO `order` (`addressId`, `start`, `end`) VALUES (3, CURRENT_TIME, NULL);
INSERT INTO `order` (`addressId`, `start`, `end`) VALUES (3, CURRENT_TIME, CURRENT_TIME);
INSERT INTO `order` (`addressId`, `start`, `end`) VALUES (3, CURRENT_TIME, NULL);