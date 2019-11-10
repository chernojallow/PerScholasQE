USE `case_study`;

-- user
INSERT INTO `user` (`username`, `password`, `role`) VALUES ('xiaolin996', 'xiaolin996.', 2);
INSERT INTO `user` (`username`, `password`, `role`) VALUES ('chenli996', 'chenli996.', 1);
INSERT INTO `user` (`username`, `password`, `role`) VALUES ('zikacherno996', 'zikacherno996.', 1);

-- address
INSERT INTO `address` (`address1`, `address2`, `city`, `state`, `country`, `postalCode`, `userID`) 
	VALUES ('5300 Gaston Ave.', 'Apt 117-A', 'Dallas', 'TX', 'US', '75214', '1');
INSERT INTO `address` (`address1`, `city`, `state`, `country`, `postalCode`, `userID`) 
	VALUES ('5008 Derbyshire Dr.', 'McKinney', 'TX', 'US', '75070', '2');
INSERT INTO `address` (`address1`, `city`, `state`, `country`, `postalCode`, `userID`) 
	VALUES ('901 Brookside St.', 'Sweetwater', 'TX', 'US', '79556', '3');
    
-- order
INSERT INTO `order` (`userID`, `tableNbr`, `time`) VALUES (1, 1, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableNbr`, `time`) VALUES (1, 2, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableNbr`, `time`) VALUES (1, 3, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableNbr`, `time`) VALUES (2, 4, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableNbr`, `time`) VALUES (2, 5, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableNbr`, `time`) VALUES (2, 6, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `tableNbr`, `time`) VALUES (3, 7, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `time`) VALUES (3, CURRENT_TIMESTAMP);
INSERT INTO `order` (`userID`, `time`) VALUES (3, CURRENT_TIMESTAMP);

