# Write your MySQL query statement below
with t as (
    select a.age_bucket,
    sum(if(activity_type='send',time_spent,0)) send_sum,
    sum(if(activity_type='open',time_spent,0)) open_sum,
    sum(time_spent) time_sum
    from
    Activities v join Age a
    on v.user_id=a.user_id
    group by age_bucket
)
select
age_bucket,
round(send_sum * 100 / time_sum, 2) send_perc,
round(open_sum * 100 / time_sum, 2) open_perc
from t
;