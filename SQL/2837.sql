# Write your MySQL query statement below
with t as (
    select u.user_id, name, sum(ifnull(`distance`, 0)) as `traveled distance`
    from Users u left join Rides r
    on u.user_id = r.user_id
    group by 1
)
select user_id, name, `traveled distance`
from t
order by 1
;