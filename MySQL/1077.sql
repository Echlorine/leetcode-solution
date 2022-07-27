# Write your MySQL query statement below
select project_id, employee_id
from (
    select p.project_id, p.employee_id, RANK() OVER (partition by p.project_id order by experience_years desc) as `rank`
    from Project p join Employee e
    on p.employee_id=e.employee_id
) t
where `rank`=1
;