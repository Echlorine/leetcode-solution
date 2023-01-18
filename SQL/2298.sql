# Write your MySQL query statement below
select
sum(dayofweek(submit_date) in (1,7)) weekend_cnt,
sum(dayofweek(submit_date) not in (1,7)) working_cnt
from Tasks;