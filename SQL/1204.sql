# Write your MySQL query statement below
with temp as (
    select person_name, sum(weight) over (order by turn rows between unbounded preceding and current row) total_weight from Queue
)
select person_name from temp
where total_weight<=1000
order by total_weight desc
limit 0,1
;

/* Write your PL/SQL query statement below */
with t as (
    select person_name, weight, sum(weight) over(order by turn) total_weight from Queue
)
select person_name from (
    select person_name from t
    where total_weight <= 1000
    order by total_weight desc
)
where rownum = 1
;