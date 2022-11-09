# Write your MySQL query statement below
with temp as (
    select *, count(*) over(partition by employee_id) department_count from Employee
)
select employee_id, department_id from temp
where department_count=1 or primary_flag='Y'
;