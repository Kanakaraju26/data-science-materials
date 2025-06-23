SELECT * from covid_india_19 order by new_cases DESC limit 10;
SELECT new_cases, Cumulative_deaths , new_cases - Cumulative_deaths  as balance from covid_india_19 order by balance DESC limit 10;
SELECT new_cases, new_deaths from covid_india_19 order by 1 DESC limit 10;
SELECT new_cases, new_deaths from covid_india_19 order by new_cases - new_deaths DESC limit 10;

SELECT dept_id,avg(salary) from emp4 group by dept_id; 
SELECT dept_id,avg(salary) from emp4 group by dept_id having avg(salary) > 65000;
SELECT  salary * 12 as aad from emp4 group by aad order by 1 ASC;
