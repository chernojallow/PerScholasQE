DROP DATABASE IF EXISTS `student_repository`;
CREATE DATABASE `student_repository`;
USE `student_repository`; 
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
	`studentId` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	KEY `name` (`name`)
) DEFAULT CHARSET=utf8;

INSERT INTO `students` VALUES('1', 'Nancy Davolio', 'nancydavoli@gmailcom');
INSERT INTO `students` VALUES('2', 'Andrew Fuller', 'andrewfuller@gmailcom');
INSERT INTO `students` VALUES('3', 'Janet Leverling', 'janetleverling@gmailcom');

/* Test Query */
SELECT studentID, name, courseSelected FROM students;

INSERT INTO `students` VALUES
('4', 'Steven Buchanan', 'stevenbuchanan@gmailcom', 'London, UK', 'Science 1');

/* Test Query */
SELECT studentID, name, courseSelected FROM students;

UPDATE students SET name = 'Margaret Peacock', email = 'margaretpeacock@gmailcom',
hometown = 'Redmond, WA', courseSelected = 'Social Studies' WHERE studentID = '4';

/* Test Query */
SELECT studentID, name, courseSelected FROM students;

DELETE FROM `students` WHERE studentId = '4';

/* Test Query */
SELECT studentID, name, courseSelected FROM students;