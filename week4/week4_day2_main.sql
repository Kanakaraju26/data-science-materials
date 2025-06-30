select * from mytable limit 10;
select * from mytable where deaths=1;
select * from mytable where deaths=1 and stateut = "Maharashtra";
SELECT *
    FROM mytable AS t1
    WHERE Deaths = 1
    AND Dates = (
    SELECT MAX(Dates)
    FROM mytable AS t2
    WHERE t2.StateUT = t1.StateUT AND t2.Deaths = 1
);
SELECT *
    FROM mytable AS t1
    WHERE Deaths = 1
    AND Dates = (
    SELECT MIN(Dates)
    FROM mytable AS t2
    WHERE t2.StateUT = t1.StateUT AND t2.Deaths = 1
);
select stateut,count(stateut) from mytable group by stateut;
select stateut,max(deaths) from mytable group by stateut order by 2 DESC;
select stateut,max(active) from mytable group by stateut order by 2 DESC;
select stateut,max(active),max(deaths),max(deaths)/max(active) as DeathRate from mytable group by stateut order by 4 DESC;
select stateut,max(confirmed),max(deaths),max(deaths)/max(confirmed) *100 as DeathRate from mytable group by stateut order by 4 DESC;
select stateut,max(confirmed),max(deaths),round(max(deaths)/max(confirmed) *100,2) as DeathRate from mytable group by stateut order by 4 DESC;