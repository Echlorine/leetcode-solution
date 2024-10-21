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

# Write your MySQL query statement below
select d.name Department, t.name Employee, salary Salary
from (
    select name, salary, departmentId, dense_rank() over (partition by departmentId order by salary desc) as rk from Employee
) t join Department d
on t.departmentId=d.id
where t.rk<4
;

/* Write your PL/SQL query statement below */
select Department, Employee, salary from (
    select d.name Department, e.name Employee, salary, dense_rank() over (partition by d.id order by salary desc) rk
    from Employee e join Department d
    on e.departmentId=d.id
) t
where rk <= 3
;