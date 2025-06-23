SELECT sum(new_cases), max(cumulative_cases) from covid_india_19;
SELECT avg(new_cases), avg(new_deaths) from covid_india_19;
SELECT min(new_cases), max(new_deaths) from covid_india_19;
SELECT var_samp(new_cases), var_samp(new_deaths) from covid_india_19;

SELECT abs(STDDEV_SAMP(new_cases)), abs(STDDEV_SAMP(new_deaths)) from covid_india_19;
SELECT ceil(STDDEV_SAMP(new_cases)), ceil(STDDEV_SAMP(new_deaths)) from covid_india_19;
SELECT FLOOR(STDDEV_SAMP(new_cases)), FLOOR(STDDEV_SAMP(new_deaths)) from covid_india_19;
SELECT round(STDDEV_SAMP(new_cases)), round(STDDEV_SAMP(new_deaths)) from covid_india_19;
SELECT POWER(3,2), SQRT(36);
SELECT exp(3), ln(3);
SELECT log(3), log10(3);
SELECT mod(17,5), sign(3);
SELECT rand() * 10, pi();
select degrees(pi()), radians(100);