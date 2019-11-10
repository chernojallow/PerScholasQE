USE `servletjspsba`; 
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
	`user_id` INT NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL, 
	PRIMARY KEY (`user_id`)
) DEFAULT CHARSET=UTF8;


INSERT INTO `users` VALUES (1, 'xiaolin996', 'xiaolin996');
SELECT * FROM `users` WHERE `user_name` = 1;