CREATE DATABASE IF NOT EXISTS `classified_ads`; 
USE `classified_ads`; 
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE if EXISTS `ads`;
CREATE TABLE `ads` (
	`adsId` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`price` DOUBLE NOT NULL,
	`status` VARCHAR(50) NOT NULL DEFAULT '',
	PRIMARY KEY (`adsId`)
) DEFAULT CHARSET=UTF8;

DROP TABLE if EXISTS `users`;
CREATE TABLE `users` (
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL
) DEFAULT CHARSET=UTF8;

INSERT INTO `users` (`username`, `password`) VALUES ('xiaolin996', 'xiaolin996');