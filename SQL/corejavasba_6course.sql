SET FOREIGN_KEY_CHECKS=0;
USE `corejavasba`;

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`(
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(50) NOT NULL,
	`details` VARCHAR(50) NOT NULL
) DEFAULT CHARSET=UTF8;

/*
INSERT INTO `course` VALUES('1', 'math1', 'Algebra 1');
INSERT INTO `course` VALUES('2', 'eng2', 'English 2');
INSERT INTO `course` VALUES('3', 'hist3', 'History 3');

SELECT `details` FROM course WHERE `name` = 'eng2';

UPDATE course SET `name` = 'sost', `details` = 'Social Studies' WHERE `id` = '1';

SELECT * FROM course;

DELETE FROM course WHERE `id` = '3';
*/