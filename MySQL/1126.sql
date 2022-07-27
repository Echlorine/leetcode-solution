# Write your MySQL query statement below
select business_id
from (
    select business_id,
    if(occurences>avg(occurences) over (partition by event_type), 1, 0) as flag
    from Events
) t
where flag=1
group by business_id
having count(*)>=2
;