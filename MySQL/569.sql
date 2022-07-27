select id, company, salary
from
(
select id, company, salary, 
row_number()over(partition by company order by salary)as ranking,
count(id) over(partition by company)as cnt
from Employee
)a
where ranking>=cnt/2 and ranking<=cnt/2+1