/* Add EndDate & Credits to studentcourse */
ALTER TABLE studentcourse
ADD EndDate DATE NOT NULL,
ADD Credits INT;

/* Change EndDate to FinishDate */
ALTER TABLE studentcourse
CHANGE COLUMN EndDate FinishDate
DATE NOT NULL;

/* Delete FinishDate & Credits */
ALTER TABLE studentcourse
DROP COLUMN FinishDate,
DROP COLUMN Credits;

/* Step 4 A */
SELECT department.name AS 'Department Name', COUNT(course.id) AS '# Courses' FROM department
JOIN course ON department.id = course.deptId
GROUP BY department.name
ORDER BY COUNT(course.id);

/* Step 4 B */
SELECT c.name AS 'CourseName' ,COUNT(sc.studentId) AS '# Students' FROM studentcourse sc
JOIN course c ON sc.courseid = c.id
GROUP BY c.name
ORDER BY COUNT(sc.studentId) DESC;

/* Step 4 C1 */
SELECT c.name AS NAME FROM course c
LEFT JOIN facultycourse fc ON c.id = fc.courseId
WHERE fc.facultyId IS NULL
GROUP BY c.name;

/* Step 4 C2 */
SELECT c.name AS NAME , COUNT(sc.studentid) AS '#_student' FROM facultycourse fc
RIGHT JOIN course c ON c.id = fc.courseId
JOIN studentcourse sc ON c.id = sc.courseId
WHERE fc.facultyId IS NULL
GROUP BY c.name
ORDER BY COUNT(sc.studentid) DESC, c.name;

/* Step 4 D */
SELECT COUNT(studentId) AS 'STUDENTS',  DATE_FORMAT(startdate, "%Y") AS 'YEAR' 
FROM studentcourse
GROUP BY startdate;

/* Step 4 E */
SELECT DATE_FORMAT(startdate, "%d-%b-%y") AS 'Start Date', COUNT(studentId) AS 'STUDENTS'
FROM studentcourse WHERE DATE_FORMAT(startdate, "%d-%b") = '25-Aug'
GROUP BY startdate;

/* Step 4 F */
SELECT s.firstname AS 'First Name', s.lastname AS 'Last Name', COUNT(c.id) AS 'Number of Courses'
FROM student s JOIN studentcourse sc ON s.id = sc.studentId
JOIN course c ON sc.courseId = c.id
/*JOIN department d ON c.deptId = d.id*/
WHERE s.majorId = c.deptId
GROUP BY s.lastname
ORDER BY COUNT(c.id), s.lastname;

/* Step 4 G */
SELECT s.firstname AS 'First Name', s.lastname AS 'Last Name', FORMAT(AVG(sc.progress), 1) AS 'Average Progress'
FROM student s JOIN studentcourse sc ON s.id = sc.studentId
GROUP BY s.lastname
HAVING AVG(sc.progress) < '50'
ORDER BY AVG(sc.progress)DESC;

/* Step 4 H1 */
SELECT c.name AS 'Course Name', AVG(sc.progress) AS 'Average Progress' FROM studentcourse sc
JOIN course c ON sc.courseId = c.id
GROUP BY c.id
ORDER BY AVG(sc.progress) DESC;

/* Step 4 H2 */
SELECT AVG(sc.progress) AS 'Max Average Progress' FROM studentcourse sc
JOIN course c ON sc.courseId = c.id
GROUP BY c.id
ORDER BY AVG(sc.progress) DESC
LIMIT 1;

/* Step 4 H3 */
SELECT f.firstname AS 'First Name', f.lastname AS 'Last Name', AVG(sc.progress) AS 'Average Progress' 
FROM studentcourse sc
JOIN course c ON sc.courseId = c.id
JOIN facultycourse fc ON c.id = fc.courseId
JOIN faculty f ON fc.facultyId = f.id
GROUP BY f.id
ORDER BY AVG(sc.progress);

/* Step 4 H4 */
SELECT  f.firstname AS 'First Name', f.lastname AS 'Last Name', AVG(sc.progress) AS 'Average Progress' 
FROM studentcourse sc
JOIN course c ON sc.courseId = c.id
JOIN facultycourse fc ON c.id = fc.courseId
JOIN faculty f ON fc.facultyId = f.id
GROUP BY f.id
HAVING AVG(sc.progress) * .9
ORDER BY AVG(sc.progress) DESC;

/* Step 4 I */
SELECT s.firstname AS 'First Name', s.lastname AS 'Last Name', 
case
	when MIN(sc.progress) < '40' then 'F'
	when MIN(sc.progress) < '50' then 'D'
	when MIN(sc.progress) < '60' then 'C'
	when MIN(sc.progress) < '70' then 'B'
	ELSE 'A'
END AS 'Min Grade',
case
	when MAX(sc.progress) < '40' then 'F'
	when MAX(sc.progress) < '50' then 'D'
	when MAX(sc.progress) < '60' then 'C'
	when MAX(sc.progress) < '70' then 'B'
	ELSE 'A'
END AS 'Max Grade' 
FROM student s JOIN studentcourse sc ON s.id = sc.studentId
GROUP BY s.id
ORDER BY AVG(sc.progress);

/* Step 4 J */
SELECT CONCAT(s.firstname, ' ', s.lastname) AS 'Student Name' FROM student s
JOIN studentcourse sc ON s.id = sc.studentId
WHERE sc.progress > (SELECT AVG(sc.progress) FROM student s JOIN studentcourse sc ON s.id = sc.studentId)
GROUP BY s.id
ORDER BY s.firstname, s.lastname;