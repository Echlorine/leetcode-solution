# Write your MySQL query statement below
select round(ifnull(avg(num),0), 2) average_sessions_per_user from (
    select count(distinct session_id) num from Activity
    where datediff('2019-07-27', activity_date)>=0 and datediff('2019-07-27', activity_date)<30
    group by user_id
) t
;