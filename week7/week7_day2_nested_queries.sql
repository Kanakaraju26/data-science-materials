SELECT avg(salary) from emp7;
SELECT * from emp7 where salary > (select avg(salary) from emp7);

SELECT emp_id, name, dept_id,salary
FROM emp7 e
WHERE salary > (
    SELECT AVG(salary)
    FROM emp7
    WHERE dept_id = e.dept_id
);

SELECT emp_id, name
FROM emp7
WHERE emp_id IN (
    SELECT emp_id
    FROM pro7
    GROUP BY emp_id
    HAVING COUNT(proj_id) > 1
);

SELECT e.dept_id, d.dept_name
FROM emp7 e
JOIN dep7 d ON e.dept_id = d.dept_id
GROUP BY e.dept_id, d.dept_name
HAVING AVG(e.salary) < 18500;

SELECT emp_id, name, dept_id
FROM emp7 e
WHERE NOT EXISTS (
    SELECT 1
    FROM pro7 p
    WHERE p.emp_id = e.emp_id
);
