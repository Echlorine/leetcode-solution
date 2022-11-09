# Write your MySQL query statement below
with temp as (
    select person_name, sum(weight) over (order by turn rows between unbounded preceding and current row) total_weight from Queue
)
select person_name from temp
where total_weight<=1000
order by total_weight desc
limit 0,1
;