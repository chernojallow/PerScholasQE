SET FOREIGN_KEY_CHECKS=0;
USE `case_study`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`userID` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(25) NOT NULL,
	`password` VARCHAR(25) NOT NULL,
	`role` TINYINT NOT NULL,
	PRIMARY KEY (`userID`),
	UNIQUE KEY `username` (`username`)
	CONSTRAINT `u_fk_addressID`
		FOREIGN KEY (`addressID`) REFERENCES `address` (`addressID`) ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
	`addressID` INT NOT NULL AUTO_INCREMENT,
	`address1` VARCHAR(50) NOT NULL,
	`address2` VARCHAR(50) NOT NULL,
	`city` VARCHAR(50) NOT NULL,
	`state` VARCHAR(50) NOT NULL,
	`country` VARCHAR(50) NOT NULL,
	`postalCode` VARCHAR(50) NOT NULL
) DEFAULT CHARSET=UTF8;

DROP TABLE if EXISTS `table`;
CREATE TABLE `table` (
	`tableID` INT NOT NULL AUTO_INCREMENT,
	`userID` INT NOT NULL,
	PRIMARY KEY (`tableID`),
	CONSTRAINT `t_fk_userID`
		FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
	`orderID` INT NOT NULL AUTO_INCREMENT,
	`userID` INT NOT NULL,
	`tableID` INT NOT NULL,
	`time` TIMESTAMP NOT NULL,
	PRIMARY KEY (`orderID`),
	KEY `tableID` (`tableID`),
	KEY `userID` (`userID`)
	/*CONSTRAINT `fk_tableID`
		FOREIGN KEY (`tableID`) REFERENCES `table` (`tableID`)
	CONSTRAINT `fk_userID`
		FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)*/
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items` (
	`orderID` INT NOT NULL,
	`categoryID` INT NOT NULL,
	`quantity` INT UNSIGNED NOT NULL,
	PRIMARY KEY (`orderID`, `categoryID`),
	CONSTRAINT `oi_fk_orderID`
		FOREIGN KEY (`orderID`) REFERENCES `order` (`orderID`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `oi_fk_categoryID`
		FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryID`) ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

DROP table if EXISTS `category`;
CREATE table `category` (
	`categoryID` INT NOT NULL AUTO_INCREMENT,
	`categoryName` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`categoryID`)
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
	`itemID` INT NOT NULL AUTO_INCREMENT,
	`itemName` VARCHAR(50) NOT NULL,
	`categoryID` INT NOT NULL,
	`price` DOUBLE UNSIGNED NOT NULL,
	PRIMARY KEY (`itemID`),
	UNIQUE KEY `itemName` (`itemName`),
	CONSTRAINT `i_fk_categoryID`
		FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryID`) ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

/* Testing
INSERT INTO `user` (`username`, `password`, `role`) VALUES ('xiaolin996', 'xiaolin996.', 1);
INSERT INTO `user` (`username`, `password`, `role`) VALUES ('chenli996', 'chenli996.', 1);
INSERT INTO `user` (`username`, `password`, `role`) VALUES ('zikacherno996', 'zikacherno996.', 1);

INSERT INTO `table` (`userID`) VALUES (1);
INSERT INTO `table` (`userID`) VALUES (1);
INSERT INTO `table` (`userID`) VALUES (1);
INSERT INTO `table` (`userID`) VALUES (2);
INSERT INTO `table` (`userID`) VALUES (2);
INSERT INTO `table` (`userID`) VALUES (2);
INSERT INTO `table` (`userID`) VALUES (3);
INSERT INTO `table` (`userID`) VALUES (3);
INSERT INTO `table` (`userID`) VALUES (3);

INSERT INTO `order` (`userID`, `tableID`, `time`) VALUES (1, 1, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableID`, `time`) VALUES (1, 2, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableID`, `time`) VALUES (1, 3, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableID`, `time`) VALUES (2, 4, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableID`, `time`) VALUES (2, 5, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableID`, `time`) VALUES (2, 6, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableID`, `time`) VALUES (3, 7, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableID`, `time`) VALUES (3, 8, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableID`, `time`) VALUES (3, 9, CURRENT_TIMESTAMP);

INSERT INTO category (`categoryName`) VALUES ('hello');
INSERT INTO category (`categoryName`) VALUES ('hey');
INSERT INTO category (`categoryName`) VALUES ('hi');

INSERT INTO `order_items` (`orderID`, `categoryID`, `quantity`) VALUES (1, 1, 1);
INSERT INTO `order_items` (`orderID`, `categoryID`, `quantity`) VALUES (1, 2, 2);
INSERT INTO `order_items` (`orderID`, `categoryID`, `quantity`) VALUES (1, 3, 3);
INSERT INTO `order_items` (`orderID`, `categoryID`, `quantity`) VALUES (2, 1, 4);
INSERT INTO `order_items` (`orderID`, `categoryID`, `quantity`) VALUES (2, 2, 5);
INSERT INTO `order_items` (`orderID`, `categoryID`, `quantity`) VALUES (2, 3, 6);
INSERT INTO `order_items` (`orderID`, `categoryID`, `quantity`) VALUES (3, 1, 7);
INSERT INTO `order_items` (`orderID`, `categoryID`, `quantity`) VALUES (3, 2, 8);
INSERT INTO `order_items` (`orderID`, `categoryID`, `quantity`) VALUES (3, 3, 9);

INSERT INTO item (`itemName`, `categoryID`, `price`) VALUES ('hello1', 1, 23.54);
INSERT INTO item (`itemName`, `categoryID`, `price`) VALUES ('hey1', 1, 23.54);
INSERT INTO item (`itemName`, `categoryID`, `price`) VALUES ('hi1', 1, 23.54);
INSERT INTO item (`itemName`, `categoryID`, `price`) VALUES ('hello2', 2, 23.54);
INSERT INTO item (`itemName`, `categoryID`, `price`) VALUES ('hey2', 2, 23.54);
INSERT INTO item (`itemName`, `categoryID`, `price`) VALUES ('hi2', 2, 23.54);
INSERT INTO item (`itemName`, `categoryID`, `price`) VALUES ('hello3', 3, 23.54);
INSERT INTO item (`itemName`, `categoryID`, `price`) VALUES ('hey3', 3, 23.54);
INSERT INTO item (`itemName`, `categoryID`, `price`) VALUES ('hi3', 3, 23.54);
*/

/*
DROP TABLE if EXISTS `report`;
CREATE TABLE `report` (
	`reportID` INT NOT NULL AUTO_INCREMENT,
	`userID` INT NOT NULL,
	`orderID` INT NOT NULL,
	PRIMARY KEY (`reportID`),
	KEY `userID` (`userID`),
	KEY `orderID` (`orderID`)
) DEFAULT CHARSET=UTF8;

DROP TABLE if EXISTS `report`;
CREATE TABLE `report` (
	`reportID` INT NOT NULL AUTO_INCREMENT,
	`userID` INT NOT NULL,
	`orderID` INT NOT NULL,
	PRIMARY KEY (`reportID`),
	FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
	FOREIGN KEY (`orderID`) REFERENCES `order` (`orderID`)
) DEFAULT CHARSET=UTF8;
*/