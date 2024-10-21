# Write your MySQL query statement below
select employee_id from Employees e
where salary<30000 and manager_id not in (select employee_id from Employees)
order by 1
;

/* Write your PL/SQL query statement below */
select employee_id from Employees e1
where not exists(
    select 1 from Employees e2
    where e1.manager_id = e2.employee_id or e1.manager_id is null
) and salary < 30000
order by employee_id
;