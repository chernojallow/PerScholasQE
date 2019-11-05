SET FOREIGN_KEY_CHECKS=0;
USE `junit_sba`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	`userId` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(25) NOT NULL,
	`password` VARCHAR(25) NOT NULL,
	`javaScore` DOUBLE NOT NULL,
	`sqlScore` DOUBLE NOT NULL
) DEFAULT CHARSET=UTF8;

/*
INSERT INTO `user` (`name`, `password`, `javaScore`, `sqlScore`) VALUES ('ChenLi', 'chenmingli', 80.2, 80.9);
INSERT INTO `user` VALUES(2, 'GouthamBuvanendiran', 'adityagoutham', 85.4, 85.7);
INSERT INTO `user` VALUES(3, 'ChernoJallow', 'zikacherno', 60.1, 60.8);
INSERT INTO `user` VALUES(4, 'LinXiao', 'xiaolin996', 70.0, 70.6);


SELECT * FROM `user`;
SELECT * FROM `user` WHERE `name` = 'ChernoJallow';
SELECT * FROM `user` WHERE `userId` = 1;

UPDATE `user` SET `name` = 'ChrisEjiofor', `password` = 'christopher', `javaScore` = 75.3, 
`sqlScore` = 75.5 WHERE `userId` = 3;
DELETE FROM `user` WHERE `userId` = 4;
SELECT * FROM `user`;
*/