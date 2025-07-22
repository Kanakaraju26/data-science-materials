create TABLE emp7 (
    emp_id int,
    name varchar(15), 
    dept_id int,
    manager_id int, 
    salary int
);

select * from emp7;

insert into emp7 values(101,"user1",5,103,20000);
insert into emp7 values(102,"user2",4,104,22000);
insert into emp7 values(103,"user3",3,105,19500);
insert into emp7 values(104,"user4",3,102,19500);
insert into emp7 values(105,"user5",2,101,18000);
insert into emp7 values(105,"user5",2,101,18000);

-- Create departments table
CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(100)
);

-- Create projects table
CREATE TABLE projects (
    proj_id INT PRIMARY KEY,
    emp_id INT,
    project_name VARCHAR(100)
);
 
INSERT INTO dep7 (dept_id, dept_name) VALUES
(1, 'Human Resources'),
(2, 'Finance'),
(3, 'Engineering'),
(4, 'Marketing'),
(5, 'Sales');

-- Insert records into projects
INSERT INTO pro7 (proj_id, emp_id, project_name) VALUES
(101, 1001, 'Website Redesign'),
(102, 1002, 'Payroll Automation'),
(103, 1003, 'Mobile App Development'),
(104, 1004, 'Market Research'),
(105, 1001, 'Customer Feedback Analysis');


SELECT * from emp7; 
SELECT * from dep7; 
SELECT * from pro7; 

SELECT e.name, d.dept_name, p.project_name
FROM emp7 e
JOIN dep7 d ON e.dept_id = d.dept_id
JOIN pro7 p ON e.emp_id = p.emp_id;

SELECT e.name AS employee, m.name AS manager
FROM emp7 e
JOIN emp7 m ON e.manager_id = m.emp_id;



