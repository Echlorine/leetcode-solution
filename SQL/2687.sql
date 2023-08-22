# Write your MySQL query statement below
select bike_number, max(end_time) end_time         
from Bikes
group by 1
order by 2 desc
;

# Write your MySQL query statement below
select bike_number, end_time from (
    select bike_number, end_time, rank() over (partition by bike_number order by end_time desc) rk
    from Bikes
) t
where rk=1
order by 2 desc
;