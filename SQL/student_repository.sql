SET FOREIGN_KEY_CHECKS=0;
USE `student_repository`;

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
	`studentId` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	`hometown` varchar(50) NOT NULL,
	`courseSelected` varchar(50) NOT NULL,
	KEY `name` (`name`)
) DEFAULT CHARSET=utf8;

INSERT INTO `students` VALUES('1', 'Nancy Davolio', 'nancydavoli@gmailcom', 'Seattle, WA', 'Algebra 1');
INSERT INTO `students` VALUES('2', 'Andrew Fuller', 'andrewfuller@gmailcom', 'Tacowa, WA', 'English 2');
INSERT INTO `students` VALUES('3', 'Janet Leverling', 'janetleverling@gmailcom', 'Kirkland, WA', 'History 3');

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