USE `sdc`;

INSERT INTO `member` (`name`, `email`, `password`, `favoriteLanguage`) VALUES ('leoliao', 'leoliao@gmail.com', 'llpassword', 'yinglish');
INSERT INTO `member` (`name`, `email`, `password`, `favoriteLanguage`) VALUES ('xiaolin', 'xiaolin@gmail.com', 'lxpassword', 'chinglish');
INSERT INTO `member` (`name`, `email`, `password`, `favoriteLanguage`) VALUES ('chenli', 'chenli@gmail.com', 'clpassword', 'english');
INSERT INTO `member` (`name`, `email`, `password`, `favoriteLanguage`) VALUES ('chernojallow', 'chernojallow@gmail.com', 'cjpassword', 'blingsh');
SELECT * FROM `member`;
SELECT * FROM `member` WHERE `name` = 'leoliao';
UPDATE `member` SET `name` = 'littletamamo', `email` = 'littletamamo@gmail.com', `password` = 'ltpassword', `favoriteLanguage` = 'yinglish' WHERE `memberId` = 4;
SELECT * FROM `member` WHERE `memberId` = 4;
DELETE FROM `member` WHERE `memberId` = 4;
SELECT * FROM `member`;