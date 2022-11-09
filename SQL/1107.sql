# Write your MySQL query statement below
with temp as (
    select user_id, min(activity_date) activity_date from Traffic
    where activity='login'
    group by user_id
    having datediff('2019-06-30', activity_date)<=90
)
select activity_date login_date, count(*) user_count from temp
group by activity_date
;