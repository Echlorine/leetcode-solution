# Write your MySQL query statement below
select name from
Employee e join
(
    select managerId, count(*) as num from Employee group by managerId having count(*)>=5
) t
on e.id=t.managerId
;

/* Write your PL/SQL query statement below */
select e2.name from Employee e1 join Employee e2
on e1.managerId=e2.id
group by e2.id, e2.name
having count(e1.id)>=5
;