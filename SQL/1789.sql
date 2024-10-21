# Write your MySQL query statement below
with temp as (
    select *, count(*) over(partition by employee_id) department_count from Employee
)
select employee_id, department_id from temp
where department_count=1 or primary_flag='Y'
;

/* Write your PL/SQL query statement below */
select employee_id, department_id from Employee e1
where primary_flag = 'Y'
or exists (
    select 1 from Employee e2
    where e1.employee_id = e2.employee_id
    group by e2.employee_id
    having count(1) = 1
)
;