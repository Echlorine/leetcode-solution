# Write your MySQL query statement below
select name as Employee from Employee as t
where salary > (select salary from Employee where id = t.managerId)
;

# Write your MySQL query statement below
select a.name as Employee
from Employee as a join Employee as b
on a.managerId=b.id
where a.salary > b.salary
;