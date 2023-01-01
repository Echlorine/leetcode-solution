# Write your MySQL query statement below
select
case
when t1.num>t2.num then "New York University"
when t1.num<t2.num then "California University"
else "No Winner"
end winner
from (
    select count(*) num
    from NewYork
    where score>=90
) t1 join (
    select count(*) num
    from California
    where score>=90
) t2
;