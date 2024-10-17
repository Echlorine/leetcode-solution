# Write your MySQL query statement below
select employee_id, project_id, employee_name, project_workload
from (
    select e.employee_id, p.project_id, e.name employee_name, workload project_workload,
    avg(workload) over(partition by e.team) as avg_workload
    from Project p join Employees e
    on p.employee_id = e.employee_id
) t
where project_workload>avg_workload
order by 1,2
;