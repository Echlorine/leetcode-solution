# Write your MySQL query statement below
with temp as (
    select company_id, max(salary) max_salary from Salaries group by company_id
)
select s.company_id, employee_id, employee_name,
case
when max_salary<1000 then round(salary,0)
when max_salary>10000 then round(salary*0.51,0)
else round(salary*0.76,0)
end salary
from Salaries s join temp t on s.company_id=t.company_id
;