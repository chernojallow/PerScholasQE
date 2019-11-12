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
		FOREIGN KEY (`members_member_id`) REFERENCES `members` (`member_id`) 
			ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `signups`;
CREATE TABLE `signups` (
	`signups_member_id` INT NOT NULL,
    `signups_event_id` INT NOT NULL,	
    PRIMARY KEY (`signups_member_id`, `signups_event_id`),
    CONSTRAINT `s_fk_eventId` FOREIGN KEY (`signups_event_id`)
		REFERENCES `events` (`event_id`)
			ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `s_fk_memberId` FOREIGN KEY (`signups_member_id`)
		REFERENCES `members` (`member_id`)
			ON UPDATE CASCADE ON DELETE CASCADE
)  DEFAULT CHARSET=UTF8;

INSERT INTO `members` (`name`, `email`, `password`, `favorite_language`) 
	VALUES ('Lin Xiao', 'xiaolin996@gmail.com', 'xiaolin996', 'C');
INSERT INTO `members` (`name`, `email`, `password`, `favorite_language`) 
	VALUES ('Chen Li', 'chenli123@gmail.com', 'chenli123', 'Java');
	
INSERT INTO `events` (`title`, `description`, `location`, `date_time`, `members_member_id`) 
	VALUES ('a', 'b', 'c', CURRENT_TIMESTAMP, 1);

INSERT INTO `signups` VALUES (2, 1);