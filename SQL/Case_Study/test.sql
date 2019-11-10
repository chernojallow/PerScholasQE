SELECT * FROM category;
INSERT INTO category (`categoryName`) VALUES ('hello');
SELECT * FROM category WHERE `categoryID` = 1;
SELECT * FROM category WHERE `categoryName` = 'hello';
UPDATE category SET `categoryName` = 'hey' WHERE `categoryID` = 1;
DELETE FROM category WHERE `categoryID` = 1;

SELECT * FROM item;
INSERT INTO item (`itemName`, `categoryID`, `price`) VALUES ('hello', 1, 23.54);
SELECT * FROM item WHERE `itemID` = 1;
SELECT * FROM item WHERE `itemName` = 'hello';
UPDATE item SET `itemName` = 'hello1', `categoryID` = 1, `price` = 54.23 WHERE `itemID` = 1;
DELETE FROM item WHERE `itemID` = 1;

SELECT * FROM `order`;
INSERT INTO `order` (`userID`, `tableID`, `time`) VALUES (1, 1, CURRENT_TIMESTAMP);
SELECT * FROM `order` WHERE `orderID` = 1;
UPDATE `order` SET `userID` = 1, `tableID` = 1, `time` = CURRENT_TIMESTAMP WHERE `orderID` = 1;
DELETE FROM `order` WHERE `orderID` = 1;

SELECT * FROM `user`;
INSERT INTO `user` (`username`, `password`, `role`) VALUES ('xiaolin996', 'xiaolin996.', 1);
SELECT * FROM `user` WHERE `userID` = 1;
SELECT * FROM `user` WHERE `username` = 'xiaolin996';
UPDATE `user` SET `username` = 'chenming123', `password` = 'chenmingli', `role` = 1 WHERE `userID` = 1;
DELETE FROM `user` WHERE `userID` = 1;

SELECT * FROM `table`;
INSERT INTO `table` (`userID`) VALUES (1);
SELECT * FROM `table` WHERE `tableID` = 1;
UPDATE `table` SET `userID` = 3 WHERE `tableID` = 5 && `userID` = 2;
DELETE FROM `table` WHERE `tableID` = 1;

SELECT * FROM `order_items`;
INSERT INTO `order_items` (`orderID`, `categoryID`, `quantity`) VALUES (1, 1, 1);
SELECT * FROM `order_items` WHERE `orderID` = 1 && `categoryID` = 2;
UPDATE `order_items` SET `categoryID` = 1, `quantity` = 2 WHERE `orderID` = 1 && `categoryID` = 1;
DELETE FROM `order_items` WHERE `orderID` = 1 && `categoryID` = 3;