CREATE TABLE dep8 (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dept_id INT,
    department_name VARCHAR(50),
    region VARCHAR(50)
);

INSERT INTO dep8 (dept_id, department_name, region) VALUES
(1, 'Human Resources', 'Mumbai'),
(2, 'Finance', 'Delhi NCR'),
(3, 'Engineering', 'Bangalore'),
(4, 'Marketing', 'Hyderabad'),
(5, 'Sales', 'Mumbai'),
(1, 'Human Resources', 'Hyderabad'),
(2, 'Finance', 'Bangalore'),
(3, 'Engineering', 'Delhi NCR'),
(4, 'Marketing', 'Mumbai'),
(5, 'Sales', 'Hyderabad'),
(1, 'Human Resources', 'Bangalore'),
(2, 'Finance', 'Mumbai'),
(3, 'Engineering', 'Hyderabad'),
(4, 'Marketing', 'Delhi NCR'),
(5, 'Sales', 'Bangalore');

CREATE TABLE emp8 (
    emp_id INT PRIMARY KEY,
    name VARCHAR(50),
    dept_id INT,
    manager_id INT,
    salary INT,
    FOREIGN KEY (dept_id) REFERENCES dep8(id),
    FOREIGN KEY (manager_id) REFERENCES emp8(emp_id)
);

INSERT INTO emp8 (emp_id, name, dept_id, manager_id, salary) VALUES
(1, 'Alice', 1, NULL, 75000),     
(2, 'Bob', 2, 1, 62000),
(3, 'Charlie', 3, 1, 68000),
(4, 'David', 4, 1, 60000),
(5, 'Eva', 5, 1, 67000),
(6, 'Frank', 6, 2, 58000),
(7, 'Grace', 7, 2, 61000),
(8, 'Hank', 8, 3, 80000),
(9, 'Ivy', 9, 3, 50000),
(10, 'Jack', 10, 4, 71000),
(11, 'Kara', 11, 5, 64000),
(12, 'Leo', 12, 5, 56000),
(13, 'Mona', 13, 6, 72000),
(14, 'Nina', 14, 7, 59000),
(15, 'Owen', 15, 8, 68000);

select e.emp_id, e.name, d.department_name 
from emp8 e JOIN dep8 d
on e.dept_id = d.id;

SELECT region, AVG(e.salary) AS avg_salary
FROM emp8 e
JOIN dep8 d ON e.dept_id = d.dept_id
GROUP BY region
HAVING AVG(e.salary) > 60000;

SELECT region, AVG(e.salary) as num_id
FROM emp8 e
JOIN dep8 d ON e.dept_id = d.id
GROUP BY region;
