SELECT e.name,e.salary from emp4 e join dep d on d.dept_id=e.dept_id;
SELECT e.name,e.salary from emp4 e inner join dep d ON d.dept_id=e.dept_id;
SELECT e.name,d.dept_name from emp4 e left join dep d on d.dept_id=e.dept_id;
SELECT e.name,d.dept_name from emp4 e right join dep d on d.dept_id=e.dept_id;
SELECT e.name,d.dept_name from emp4 e cross join dep d;
SELECT e.Name, m.Name FROM emp4 e left JOIN emp4 m ON e.name = m.name;
SELECT e.name, d.dept_name 
FROM emp4 e 
LEFT JOIN dep d ON e.dept_id = d.dept_id
UNION
SELECT e.name, d.dept_name 
FROM emp4 e 
RIGHT JOIN dep d ON e.dept_id = d.dept_id;