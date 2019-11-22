DROP DATABASE IF EXISTS `snack_signup`;
CREATE DATABASE `snack_signup`;
USE `snack_signup`; 
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
	`studentId` INT NOT NULL AUTO_INCREMENT,
	`firstName` VARCHAR(25) NOT NULL,
	`lastName` VARCHAR(25) NOT NULL,
	`username` VARCHAR(25) NOT NULL,
	`password` VARCHAR(25) NOT NULL,
	PRIMARY KEY (`studentId`),
	UNIQUE KEY `username` (`username`)
) DEFAULT CHARSET=UTF8;

INSERT INTO `student` (`firstName`, `lastName`, `username`, `password`) VALUES ('Lin', 'Xiao', 'xiaolin996', 'xiaolin996');
SELECT * FROM `student` WHERE `studentId` = 1;
UPDATE `student` SET `firstName` = 'Chen', `lastName` = 'Li', `username` = 'chenli123', `password` = 'chenli123' WHERE `studentId` = 1;
SELECT * FROM `student` WHERE `username` = 'chenli123';
DELETE FROM `student` WHERE `studentId` = 1;
SELECT * FROM `student`;
