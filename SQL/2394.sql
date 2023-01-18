# Write your MySQL query statement below
select e.employee_id
from Employees e left join (
    select employee_id, sum(ceil(timestampdiff(second,in_time,out_time)/60)) work_minutes
    from Logs
    group by 1
) t
on e.employee_id=t.employee_id
where t.work_minutes<e.needed_hours*60 or t.work_minutes is null
;