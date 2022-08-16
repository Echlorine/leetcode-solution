# Write your MySQL query statement below
select Id, Month, sum(Salary) over (partition by Id order by Month desc range between current row and 2 following) Salary
from (
    select Id, Month, Salary from (
        select Id, Month, Salary, row_number () over (partition by Id order by Month desc) rk from Employee
    ) t
    where t.rk >=2
) T1
order by id, Month desc
;