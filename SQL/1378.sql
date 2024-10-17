# Write your MySQL query statement below
select unique_id, name from Employees s left join EmployeeUNI i on s.id=i.id;

/* Write your PL/SQL query statement below */
select e2.unique_id, e1.name
from Employees e1 left join EmployeeUNI e2
on e1.id = e2.id
;