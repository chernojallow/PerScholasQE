/* Member */
INSERT INTO member (`name`, `email`, `password`, `fGenre`) VALUES ('Lin Xiao', 'xiaolin996@gmail.com', 'xiaolin996', 'Science Fiction');
INSERT INTO member (`name`, `email`, `password`, `fGenre`) VALUES ('Lin Xiao', 'xiaolin996@gmail.com', 'xiaolin996', 'Science Fiction');
INSERT INTO member (`name`, `email`, `password`, `fGenre`) VALUES ('Lin Xiao', 'xiaolin996@gmail.com', 'xiaolin996', 'Science Fiction');
SELECT * FROM member;
UPDATE member SET `name` = 'Chen Li', `email` = 'chenli123@gmail.com', `password` = 'chenli123', `fGenre` = 'Fiction' WHERE `memberID` = 2;
DELETE FROM member WHERE `memberID` = 3;
SELECT * FROM member;
SELECT * FROM member WHERE `name` = 'Lin Xiao';
SELECT * FROM member WHERE `memberID` = 2;
DELETE FROM member WHERE `memberID` = 2;
DELETE FROM member WHERE `memberID` = 1;
ALTER TABLE member AUTO_INCREMENT = 1;
SELECT * FROM member;

/* Book */
INSERT INTO book (`title`, `synopsis`, `author`, `pDate`, `memberID`) VALUES ('title1', 'synopsis1', 'author1', CURRENT_DATE, 1);
INSERT INTO book (`title`, `synopsis`, `author`, `pDate`, `memberID`) VALUES ('title2', 'synopsis2', 'author2', CURRENT_DATE, 2);
INSERT INTO book (`title`, `synopsis`, `author`, `pDate`, `memberID`) VALUES ('title3', 'synopsis3', 'author3', CURRENT_DATE, 1);
INSERT INTO book (`title`, `synopsis`, `author`, `pDate`, `memberID`) VALUES ('title4', 'synopsis4', 'author4', CURRENT_DATE, 2);
SELECT * FROM book;
UPDATE book SET `title` = 'titleu', `synopsis` = 'synopsisu', `author` = 'authoru', `pDate` = CURRENT_DATE, `memberID` = 2 WHERE `bookID` = 4;
DELETE FROM book WHERE `bookID` = 3;
SELECT * FROM book;
SELECT * FROM book WHERE `bookID` = 1;
SELECT * FROM book WHERE `title` = 'title2';
DELETE FROM book WHERE `bookID` = 1;
DELETE FROM book WHERE `bookID` = 2;
DELETE FROM book WHERE `bookID` = 4;
ALTER TABLE book AUTO_INCREMENT = 1;
SELECT * FROM book;