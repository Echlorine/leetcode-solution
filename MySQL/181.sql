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

# Write your MySQL query statement below
select e1.name as 'Employee'
from Employee e1 join Employee e2
on e1.managerId=e2.id and e1.salary>e2.salary
;