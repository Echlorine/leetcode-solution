# Write your MySQL query statement below
SELECT e1.employee_id
FROM Employees e1
JOIN Employees e2 ON e1.manager_id = e2.employee_id
JOIN Employees e3 ON e2.manager_id = e3.employee_id
WHERE e1.employee_id != 1 AND e3.manager_id = 1
;

with recursive temp as (
    select employee_id, manager_id from Employees e where e.manager_id=1 and e.employee_id!=1
    union all
    select e.employee_id, e.manager_id from Employees e, temp t where t.employee_id=e.manager_id
)
select employee_id from temp