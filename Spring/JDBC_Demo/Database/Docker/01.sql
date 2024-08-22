CREATE USER 'appusr'@'%' IDENTIFIED BY 'appusr@1234';
GRANT ALL PRIVILEGES ON *.* TO 'appusr'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

USE appdb;

CREATE TABLE Students
(
   StudentID int,   
   StudentName varchar(1000),
   Marks numeric(2,1)
);

INSERT INTO Students(StudentID,StudentName,Marks) VALUES(1, 'John',4.5);

INSERT INTO Students(StudentID,StudentName,Marks) VALUES(2,'Jess',4.6);

INSERT INTO Students(StudentID,StudentName,Marks) VALUES(3,'Smith',4.7);

SELECT * FROM Students;

Select StudentName from Students where StudentID = 1