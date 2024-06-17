-- List all the databases in the system -----> (SHOW)
SHOW DATABASES;
-- Create a new database named pretraining ----->(CREATE DATABASE)
CREATE DATABASE pretraining; 
-- Start working on 'pretraining' database ----->(USE)
USE pretraining;

-- Create Customers Table ----->(CREATE TABLE, NOT NULL, UNIQUE, PRIMARY KEY)
CREATE TABLE CUSTOMERS (ID INT NOT NULL UNIQUE, NAME VARCHAR (20) NOT NULL, AGE INT NOT NULL, ADDRESS CHAR (25), SALARY DECIMAL (18, 2), PRIMARY KEY (ID));
-- Set DEFAULT Value for Salary column as 5000 ----->(ALTER, DEFAULT)
ALTER TABLE CUSTOMERS MODIFY SALARY DECIMAL (18, 2) DEFAULT 5000.00;
-- Add CHECK condition to age column to ensure customers age is >= 18 ----->(CHECK)
ALTER TABLE CUSTOMERS MODIFY AGE INT NOT NULL CHECK (AGE >= 18 );

-- Create Orders Table ----->(AUTO_INCREMENT)
CREATE TABLE ORDERS (ID INT NOT NULL AUTO_INCREMENT, DATE DATETIME, CUSTOMER_ID INT, AMOUNT double, PRIMARY KEY (ID));
-- Make Customer_id foreign key and reference customers table ----->(FOREIGN KEY)
ALTER TABLE ORDERS ADD FOREIGN KEY (Customer_ID) REFERENCES CUSTOMERS (ID);
-- SET Id column to start from 100
ALTER TABLE ORDERS AUTO_INCREMENT=100;

-- List all the tables in the database you are working on
SHOW TABLES;
-- Details of a table like column name and type
DESCRIBE pretraining.ORDERS;

-- Insert rows in customers table ----->(INSERT INTO)
INSERT INTO CUSTOMERS (ID, NAME , AGE, ADDRESS, SALARY) VALUES (1, 'Ramesh', 32, 'Ahmedabad', 2000.00);
INSERT INTO CUSTOMERS (ID, NAME, AGE, ADDRESS, SALARY) VALUES (2, 'Khilan', 25, 'Delhi', 1500.00);
INSERT INTO CUSTOMERS (ID, NAME, AGE, ADDRESS, SALARY) VALUES (3, 'kaushik', 23, 'Kota', 2000.00);
INSERT INTO CUSTOMERS (ID, NAME, AGE, ADDRESS, SALARY) VALUES (4, 'Chaitali', 25, 'Mumbai', 6500.00);
INSERT INTO CUSTOMERS (ID, NAME, AGE, ADDRESS, SALARY) VALUES (5, 'Hardik', 27, 'Bhopal', 8500.00);
INSERT INTO CUSTOMERS (ID, NAME, AGE, ADDRESS, SALARY) VALUES (6, 'Komal', 22, 'MP', 4500.00);
INSERT INTO CUSTOMERS (ID, NAME, AGE, ADDRESS, SALARY) VALUES (7, 'Muffy', 24, 'Indore', 10000.00);
INSERT INTO CUSTOMERS (ID, NAME, AGE, ADDRESS, SALARY) VALUES (8, 'Rajesh', 25, 'Mumbai', 3500.00);
INSERT INTO CUSTOMERS (ID, NAME, AGE, ADDRESS, SALARY) VALUES (9, 'Kamlesh', 26, 'Kota', 5000.00);
INSERT INTO CUSTOMERS (ID, NAME, AGE, ADDRESS, SALARY) VALUES (10, 'OldName', 28, 'OldCity', 5000.00);
INSERT INTO CUSTOMERS (ID, NAME, AGE) VALUES (11, 'Kalpesh', 26);
INSERT INTO CUSTOMERS (ID, NAME, AGE) VALUES (12, 'Kalp', 23);

-- create index in Customers table based on age ----->(INDEX)
CREATE INDEX index_age ON CUSTOMERS (AGE);
-- create unique index in Customers table based on name
CREATE UNIQUE INDEX index_name ON CUSTOMERS (NAME);

-- If user enters '1005 OR 1=1' then al the rows in the database will be returned ----->(SQL INJECTION)
SELECT * FROM CUSTOMERS WHERE ID = 1005 OR 1=1;

-- Show all rows and columns in customers table ----->(SELECT)
SELECT * FROM CUSTOMERS;
-- Remove row having id = 12 from customers table ----->(DELETE)
DELETE FROM CUSTOMERS WHERE ID= 12;
-- Show id and name column from customers table
SELECT ID, NAME FROM CUSTOMERS;
-- Show all the distinct values in address column of customers table ----->(DISTINCT) 
SELECT DISTINCT ADDRESS FROM CUSTOMERS;
-- Show rows from customers table which have id = 10 ----->(WHERE)
SELECT * FROM CUSTOMERS WHERE ID = 10;
-- Update the name, address and salary of row having id = 10, in customers table ----->(UPDATE)
UPDATE CUSTOMERS SET Name = 'Riya', Address= 'Mumbai', Salary = 6500.00 WHERE ID = 10;

-- Show name, age and address of customers whose age is < 26
SELECT NAME, AGE, ADDRESS FROM CUSTOMERS WHERE AGE < 26;
-- Show name, age and address of customers whose age is < 26 and address is not mumbai ----->(AND)
SELECT NAME, AGE, ADDRESS FROM CUSTOMERS WHERE AGE < 26 AND ADDRESS != 'Mumbai';
-- Show name, age and address of customers whose age is >= 26 or address is not mumbai ----->(OR)
SELECT NAME, AGE, ADDRESS FROM CUSTOMERS WHERE AGE >= 26 OR ADDRESS <> 'Mumbai';

-- Display id, salary and name of customers in ascending order of salary ----->(ORDER BY)
SELECT ID, SALARY, NAME FROM CUSTOMERS ORDER BY SALARY;
-- Display id, salary and name of customers in ascending order of salary, followed by acsending order of name
SELECT ID, SALARY, NAME FROM CUSTOMERS ORDER BY SALARY, NAME;

-- Show first 3 entries in customers table ----->(LIMIT)
SELECT * FROM Customers LIMIT 3;
-- Show customers whose name starts with 'Ra' ----->(LIKE)
SELECT * FROM CUSTOMERS WHERE NAME LIKE 'Ra%';
-- Show customers whose age is 25 or 27 ----->(IN)
SELECT * FROM CUSTOMERS WHERE AGE IN (25, 27);
-- Show customers whose age is in the range 25 to 27, both inclusive ----->(BETWEEN)
SELECT * FROM CUSTOMERS WHERE AGE BETWEEN 25 AND 27;

-- Show id and salary of customers whose salary has 5 in 2nd position from left followed by 0/more numbers ----->(WILDCARDS _, %)
SELECT ID, SALARY FROM CUSTOMERS WHERE SALARY LIKE '_5%';
-- Show id and salary of customers whose salary has 5 in 1st position from left followed by 0/more numbers
SELECT ID, SALARY FROM CUSTOMERS WHERE SALARY LIKE '5%';

-- Insert values into Orders table
INSERT INTO ORDERS (DATE, CUSTOMER_ID, AMOUNT) VALUES (TIMESTAMP('2009-10-08 00:00:00'), 3, 1500); 
INSERT INTO ORDERS (DATE, CUSTOMER_ID, AMOUNT) VALUES (TIMESTAMP('2009-11-20 00:00:00'), 2, 1560);
INSERT INTO ORDERS (DATE, CUSTOMER_ID, AMOUNT) VALUES (TIMESTAMP('2009-10-08 00:00:00'), 3, 3000);
INSERT INTO ORDERS (DATE, CUSTOMER_ID, AMOUNT) VALUES (TIMESTAMP('2008-05-20 00:00:00'), 4, 2060);
INSERT INTO ORDERS (ID, DATE, CUSTOMER_ID, AMOUNT) VALUES (105, TIMESTAMP('2008-05-13 00:00:00'), 11, 1000);
INSERT INTO ORDERS (DATE, CUSTOMER_ID, AMOUNT) VALUES (TIMESTAMP('2008-02-16 00:00:00'), 4, 1070);

-- Inner Join on customer_id ----->(INNER JOIN)
SELECT CUSTOMERS.ID, NAME, AMOUNT, DATE FROM CUSTOMERS INNER JOIN ORDERS ON CUSTOMERS.ID = ORDERS.CUSTOMER_ID;
-- Left Join on customer_id ----->(LEFT JOIN)
SELECT CUSTOMERS.ID, NAME, AMOUNT, DATE FROM CUSTOMERS LEFT JOIN ORDERS ON CUSTOMERS.ID = ORDERS.CUSTOMER_ID;
-- Right Join on customer_id ----->(RIGHT JOIN)
SELECT CUSTOMERS.ID, NAME, AMOUNT, DATE FROM CUSTOMERS RIGHT JOIN ORDERS ON CUSTOMERS.ID = ORDERS.CUSTOMER_ID;
-- Full Join on customer_id ----->(UNION)
SELECT CUSTOMERS.ID, NAME, AMOUNT, DATE FROM CUSTOMERS LEFT JOIN ORDERS ON CUSTOMERS.ID = ORDERS.CUSTOMER_ID UNION
SELECT CUSTOMERS.ID, NAME, AMOUNT, DATE FROM CUSTOMERS RIGHT JOIN ORDERS ON CUSTOMERS.ID = ORDERS.CUSTOMER_ID;

-- Self join based on salary comparison [Can be used to see who has more salary than a particular person] ----->(ALIASES)
SELECT a.Name, b.NAME, a.SALARY FROM CUSTOMERS a, CUSTOMERS b WHERE a.SALARY < b.SALARY;
-- Cross Join
SELECT CUSTOMERS.ID, NAME, AMOUNT, DATE FROM CUSTOMERS, ORDERS;

-- Create a customersMumbai table
CREATE TABLE CUSTOMERSMUMBAI (ID INT NOT NULL UNIQUE, NAME VARCHAR (20) NOT NULL, ADDRESS CHAR (25), PRIMARY KEY (ID));
-- Insert into customersMumbai table id, name and address of all rows of customers table having address = mumbai ----->(INSERT INTO SELECT)
INSERT INTO CUSTOMERSMUMBAI (ID, NAME, ADDRESS) SELECT ID, NAME, ADDRESS FROM CUSTOMERS WHERE ADDRESS = 'MUMBAI';
-- Show all rows in customersMumbai table
SELECT * FROM CUSTOMERSMUMBAI;
-- Remove customersMumbai table ----->(DROP)
DROP TABLE CUSTOMERSMUMBAI;

-- Show average salary for each address and no. of rows in the table corresponding to each address ----->(GROUP BY, AVG(), COUNT())
SELECT ADDRESS, AVG(SALARY) AS 'Average Salary', COUNT(ADDRESS) AS 'COUNT' FROM CUSTOMERS GROUP BY ADDRESS;
-- Show addresses having more than 2 entries in the table and no. of entries for each of the addresses ----->(HAVING)
SELECT COUNT(AGE), ADDRESS FROM CUSTOMERS GROUP BY ADDRESS HAVING COUNT(AGE) >= 2;

-- Create a customersView view which contains name and address of customers whose address is not null ----->(VIEW)
CREATE VIEW CUSTOMERS_VIEW AS SELECT NAME, ADDRESS FROM CUSTOMERS WHERE ADDRESS IS NOT NULL;
-- In customersView set address of ramesh as null ----->(NULL)
UPDATE CUSTOMERS_VIEW SET ADDRESS = NULL WHERE name='Ramesh';
-- Show all rows in customersView (Note that Ramesh's entry is removed since his address becomes null and the condition of the view is that address cannot be null)
SELECT * FROM CUSTOMERS_VIEW;

-- For CallableStatement, PreparedStatement please refer com.assignment.dbms package in javaBasics folder.
-- The stored procedures for the same are mentioned in the world-procedures.sql file in javaBasics folder.
-- Also note that the world database provided by MySQL (sample databases) is used for these procedures.
