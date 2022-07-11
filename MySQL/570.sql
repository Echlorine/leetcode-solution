# Write your MySQL query statement below
select name from
Employee e join
(
    select managerId, count(*) as num from Employee group by managerId having count(*)>=5
) t
on e.id=t.managerId
;