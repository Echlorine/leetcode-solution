# Write your MySQL query statement below
select activity_date as day, count(distinct user_id) as active_users
from Activity
where datediff('2019-07-27', activity_date) < 30 and datediff('2019-07-27', activity_date)>=0
group by activity_date
;

/* Write your PL/SQL query statement below */
-- select trunc(activity_date) day, count(distinct user_id) active_users
select TO_CHAR(activity_date, 'yyyy-mm-dd') day, count(distinct user_id) active_users
from Activity
where activity_date between to_date('2019-07-27', 'yyyy-mm-dd') - 29  and to_date('2019-07-27', 'yyyy-mm-dd')
group by activity_date
;