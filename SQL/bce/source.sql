DROP DATABASE IF EXISTS `bce`;
CREATE DATABASE `bce`; 
USE `bce`; 
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
 `memberID` INT NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(50) NOT NULL,
 `email` VARCHAR(50) NOT NULL,
 `password` VARCHAR(25) NOT NULL,
 `fGenre` VARCHAR(25) NOT NULL, 
 PRIMARY KEY (`memberID`)
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
	`bookID` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(50) NOT NULL,
	`synopsis` VARCHAR(255) NOT NULL,
	`author` VARCHAR(50) NOT NULL,
	`pDate` DATE NOT NULL,
	`memberID` INT NOT NULL, 
	PRIMARY KEY (`bookID`),
	CONSTRAINT `b_fk_memberID` 
		FOREIGN KEY (`memberID`) REFERENCES `member` (`memberID`) 
			ON UPDATE CASCADE ON DELETE CASCADE
) DEFAULT CHARSET=UTF8;

INSERT INTO member (`name`, `email`, `password`, `fGenre`) VALUES ('Lin Xiao', 'xiaolin996@gmail.com', 'xiaolin996', 'Science Fiction');
INSERT INTO member (`name`, `email`, `password`, `fGenre`) VALUES ('Chen Li', 'chenli123@gmail.com', 'chenli123', 'Fiction');
INSERT INTO member (`name`, `email`, `password`, `fGenre`) VALUES ('Goutham Buvan', 'gbuvan123@gmail.com', 'gvuan123', 'Action');
SELECT * FROM member;

INSERT INTO book (`title`, `synopsis`, `author`, `pDate`, `memberID`) VALUES ('title1', 'synopsis1', 'author1', '1997-12-05', 1);
INSERT INTO book (`title`, `synopsis`, `author`, `pDate`, `memberID`) VALUES ('title2', 'synopsis2', 'author2', '2000-12-31', 2);
INSERT INTO book (`title`, `synopsis`, `author`, `pDate`, `memberID`) VALUES ('title3', 'synopsis3', 'author3', '1973-08-15', 3);
INSERT INTO book (`title`, `synopsis`, `author`, `pDate`, `memberID`) VALUES ('title4', 'synopsis4', 'author4', '2019-09-01', 1);
INSERT INTO book (`title`, `synopsis`, `author`, `pDate`, `memberID`) VALUES ('title5', 'synopsis5', 'author5', '2018-05-20', 2);
INSERT INTO book (`title`, `synopsis`, `author`, `pDate`, `memberID`) VALUES ('title6', 'synopsis6', 'author6', '2012-09-01', 3);
SELECT * FROM book;