# Write your MySQL query statement below
with temp as (
    select *, row_number() over (partition by gender order by user_id) rk from Genders
)
select user_id, gender from temp order by rk, gender
;