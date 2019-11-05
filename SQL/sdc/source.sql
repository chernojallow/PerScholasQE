DROP DATABASE IF EXISTS `sdc`;
CREATE DATABASE `sdc`;
USE `sdc`; 
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
	`member_id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`password` VARCHAR(25) NOT NULL,
	`favorite_language` VARCHAR(25) NOT NULL, 
	PRIMARY KEY (`member_id`)
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `events`;
CREATE TABLE `events` (
	`event_id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(50) NOT NULL,
    `description` VARCHAR(50) NOT NULL,
    `location` VARCHAR(50) NOT NULL,
    `date_time` TIMESTAMP NOT NULL,
    `members_member_id` INT NOT NULL,
    PRIMARY KEY (`event_id`),
    CONSTRAINT `e_fk_memberID` 
		FOREIGN KEY (`members_member_id`) REFERENCES `member` (`member_id`) 
			ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;
