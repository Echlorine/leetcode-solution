# Write your MySQL query statement below
select min(log_id) start_id, max(log_id) end_id
from (
    select log_id, log_id - row_number() over (order by log_id) as part from Logs
) t
group by part
order by start_id
;