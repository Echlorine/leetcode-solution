# Write your MySQL query statement below
with t as (
    select *, rank() over(partition by id order by month desc) rk from Employee
)
select id, month, sum(salary) over(partition by id order by month desc range between current row and 2 following) salary
from t
where rk > 1
order by 1, 2 desc
;

# Write your MySQL query statement below
select id, month, sum(salary) over(partition by id order by month desc range between current row and 2 following) salary
from Employee
where (id, month) not in (select id, max(`month`) `month` from Employee group by id)
order by 1, 2 desc