# Write your MySQL query statement below
select
contest_id,
round(count(user_id)/(select count(user_id) from Users)*100, 2) as percentage
from Register
group by contest_id
order by percentage desc, contest_id
;

/* Write your PL/SQL query statement below */
with t as (
    select count(user_id) cnt from Users
)
select contest_id, round(count(user_id)/(select cnt from t)*100, 2) as percentage
from Register
group by contest_id
order by percentage desc, contest_id
;