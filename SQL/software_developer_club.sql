DROP DATABASE IF EXISTS `sdc`;
CREATE DATABASE `sdc`;
USE `sdc`;
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
    `memberId` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(25) NOT NULL,
    `email` VARCHAR(25) NOT NULL,
    `password` VARCHAR(25) NOT NULL,
    `favoriteLanguage` VARCHAR(25) NOT NULL,
    PRIMARY KEY (`memberId`)
)  DEFAULT CHARSET=UTF8;

insert into 

drop table if exists `event`;
CREATE TABLE `event` (
    `eventId` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(25) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `location` VARCHAR(25) NOT NULL,
    `dateTime` TIMESTAMP NOT NULL,
    `memberId` INT NOT NULL,
    PRIMARY KEY (`eventId`),
    CONSTRAINT `e_fk_memberId` FOREIGN KEY (`memberId`)
        REFERENCES `member` (`memberId`)
        ON UPDATE CASCADE ON DELETE CASCADE
)  DEFAULT CHARSET=UTF8;

drop table if exists `signup`;
CREATE TABLE `signup` (
    `memberId` INT NOT NULL,
    `eventId` INT NOT NULL,
    PRIMARY KEY (`eventId` , `memberId`),
    CONSTRAINT `l_fk_eventId` FOREIGN KEY (`eventId`)
        REFERENCES `event` (`eventId`)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT `l_fk_memberId` FOREIGN KEY (`memberId`)
        REFERENCES `member` (`memberId`)
        ON UPDATE CASCADE ON DELETE CASCADE
)  DEFAULT CHARSET=UTF8;