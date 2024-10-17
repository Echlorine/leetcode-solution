# Write your MySQL query statement below
select machine_id, round(sum(if(activity_type='start', -timestamp, timestamp))/count(distinct process_id),3) as processing_time
from Activity
group by machine_id
;

-- 注意：Oracle 中没有 if 表达式
/* Write your PL/SQL query statement below */
select machine_id, round(avg(
    case 
    when activity_type='start' then -timestamp
    else timestamp
    end
) * 2, 3) processing_time
from Activity
group by machine_id
;