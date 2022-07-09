# Write your MySQL query statement below
select query_name,
round(sum(rating/position)/count(*), 2) as quality,
round(sum(rating<3)/count(*)*100, 2) as poor_query_percentage
from Queries
group by query_name
;

# Write your MySQL query statement below
select query_name,
round(avg(rating/position), 2) as quality,
round(avg(rating<3)*100, 2) as poor_query_percentage
from Queries
group by query_name
;