# Write your MySQL query statement below
with t as (
    select user1, user2 from Friends
    union all
    select user2, user1 from Friends
),
cnt as (
    select count(distinct user1) num from t
)
select user1, round(count(distinct user2) / (select num from cnt) * 100, 2) percentage_popularity
from t
group by 1
order by 1
;