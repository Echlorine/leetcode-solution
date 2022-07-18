# Write your MySQL query statement below
select t.Department, e1.name as 'Employee', t.Salary
from Employee e1 join (
    select d.name as 'Department', max(e2.salary) as Salary, e2.departmentId as 'departmentId'
    from Employee e2 join Department d
    on e2.departmentId=d.id
    group by d.name
) as t
where e1.departmentId = t.departmentId and e1.salary=t.Salary
;

# Write your MySQL query statement below
select d.name as Department, e.name as Employee, e.salary as Salary
from Employee e join Department d
on e.departmentId=d.id
join (
    select departmentId, max(salary) as salary from Employee group by departmentId
) t
on e.departmentId=t.departmentId and e.salary=t.salary
;

# Write your MySQL query statement below
select d.name as 'Department', e.name as 'Employee', e.salary as 'Salary'
from Employee e join Department d
on e.departmentId=d.id
where (e.departmentId, e.salary) in (select departmentId, max(salary) from Employee group by departmentId)
;