# Write your MySQL query statement below
select e.*, t.team_id
from Employees e join (
    select salary, dense_rank() over (order by salary) team_id
    from Employees
    group by salary
    having count(salary)>1
) t
on e.salary=t.salary
order by t.team_id, e.employee_id
;