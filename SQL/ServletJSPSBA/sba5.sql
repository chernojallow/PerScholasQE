DROP DATABASE IF EXISTS `home_insurance`;
CREATE DATABASE `home_insurance`;
USE `home_insurance`; 
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
	`userId` INT NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(50) NOT NULL,
    `lastName` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `username` VARCHAR(20) NOT NULL,
    `password` VARCHAR(20) NOT NULL,
    `dob` DATE NOT NULL,
    PRIMARY KEY (`userId`),
    UNIQUE KEY `username` (`username`)
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `home`;
CREATE TABLE `home` (
	`homeId` INT NOT NULL AUTO_INCREMENT,
    `userId` INT NOT NULL,
    `address1` VARCHAR(255) NOT NULL,
    `address2` VARCHAR(50),
    `city` VARCHAR(20) NOT NULL,
    `state` VARCHAR(2) NOT NULL,
    `zip` INT(5) NOT NULL,
    `yearBuilt` INT(4) NOT NULL,
    `homeValue` DOUBLE NOT NULL,
    PRIMARY KEY (`homeId`),
    CONSTRAINT `h_fk_userId`
		FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
			ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `quote`;
CREATE TABLE `quote` (
	`quoteId` INT NOT NULL AUTO_INCREMENT,
    `homeId` INT NOT NULL,
    `yearlyPremium` DOUBLE NOT NULL,
    `startDate` DATE NOT NULL,
    `expiration` DATE NOT NULL,
    `active` BOOLEAN NOT NULL,
    PRIMARY KEY (`quoteId`),
    CONSTRAINT `q_fk_homeId`
		FOREIGN KEY (`homeId`) REFERENCES `home` (`homeId`)
			ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

INSERT INTO `users` (`firstName`, `lastName`, `email`, `username`, `password`, `dob`) 
	VALUES ('Lin', 'Xiao', 'xiaolin996@gmail.com', 'xiaolin', 'xiaolin996', '1997-12-05');
INSERT INTO `home` (`userId`, `address1`, `address2`, `city`, `state`, `zip`, `yearBuilt`, `homeValue`) 
	VALUES ('1', 'addr11', 'addr21', 'city1', 's1', '111', '1111', '1.11');
INSERT INTO `quote` (`homeId`, `yearlyPremium`, `startDate`, `expiration`, `active`) 
	VALUES ('1', '1111.11', '2019-11-01', '2020-11-01', true);
    
SELECT * FROM `users`;
SELECT * FROM `home`;
SELECT * FROM `quote`;