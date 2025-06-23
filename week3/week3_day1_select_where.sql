select * from covid_data where country ="India";
create table covid_india_19 as select * from covid_data where country ="India";
describe covid_india_19;
select * from covid_india_19;
select * from covid_india_19 where date_reported >="2025-01-01";
SELECT * FROM covid_data WHERE WHO_region = 'SEAR' and country = "india";
select * from covid_india_19 where new_deaths >= 4525.50;
select sum(new_deaths) from covid_india_19 where date_reported between '2020-03-22' and '2021-07-01';
select * from covid_india_19 WHERE new_cases LIKE '999%';
select count(Date_reported) from covid_india_19 WHERE new_cases is null and date_reported < '2024-07-01';
select * from covid_india_19 WHERE new_cases like '99%' or new_deaths like '99%';
SELECT LEFT(new_cases, 2)
FROM covid_india_19
WHERE CAST(new_cases AS CHAR) LIKE '99%'
   OR CAST(new_cases AS CHAR) LIKE '88%'
   OR CAST(new_cases AS CHAR) LIKE '77%'
   OR CAST(new_cases AS CHAR) LIKE '66%'
   OR CAST(new_cases AS CHAR) LIKE '55%'
   OR CAST(new_cases AS CHAR) LIKE '44%'
   OR CAST(new_cases AS CHAR) LIKE '33%'
   OR CAST(new_cases AS CHAR) LIKE '22%'
   OR CAST(new_cases AS CHAR) LIKE '11%';