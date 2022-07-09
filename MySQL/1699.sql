# Write your MySQL query statement below
select from_id as person1, to_id as person2, count(duration) as call_count, sum(duration) as total_duration
from Calls
group by least(from_id,to_id), greatest(from_id,to_id)
;