# Write your MySQL query statement below
select d1.name as 'Department', e1.Name as 'Employee', e1.salary as Salary
from Employee e1 join Department d1
on e1.departmentId=d1.id
where 3 >
(
    select count(distinct e2.Salary)
    from Employee e2
    where e2.Salary > e1.Salary and e2.departmentId = e1.departmentId
)
order by d1.name, e1.salary desc
;