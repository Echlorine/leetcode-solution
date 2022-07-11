# Write your MySQL query statement below
select e.employee_id, t.team_size
from Employee e
join
(select team_id, count(*) as team_size from Employee group by team_id) t
on e.team_id=t.team_id
;

# Write your MySQL query statement below
select employee_id, count(*) over(partition by team_id) as team_size from Employee;