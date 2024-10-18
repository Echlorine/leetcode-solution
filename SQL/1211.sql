# Write your MySQL query statement below
select query_name,
round(sum(rating/position)/count(*), 2) as quality,
round(sum(rating<3)/count(*)*100, 2) as poor_query_percentage
from Queries
where query_name is not null
group by query_name
;

# Write your MySQL query statement below
select query_name,
round(avg(rating/position), 2) as quality,
round(avg(rating<3)*100, 2) as poor_query_percentage
from Queries
where query_name is not null
group by query_name
;

/* Write your PL/SQL query statement below */
select query_name, 
round(avg(rating / position), 2) quality,
round(sum(case when rating < 3 then 1 else 0 end) * 100 / count(*), 2) poor_query_percentage
from Queries
where query_name is not null
group by query_name
;