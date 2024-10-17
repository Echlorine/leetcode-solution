# Write your MySQL query statement below
with t as (
    select user_id, session_type, dense_rank() over(partition by user_id order by session_start) rk
    from Sessions
), temp as (
    select user_id from t
    where rk=1 and session_type='Viewer'
)
select s.user_id, count(*) sessions_count
from Sessions s join temp t
on s.user_id = t.user_id
where session_type='Streamer'
group by 1
order by 2 desc, 1 desc
;