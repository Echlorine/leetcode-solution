# Write your MySQL query statement below
select s1.id, s2.student
from Seat s1 join Seat s2
on (s1.id=s2.id-1 and s1.id%2=1) or (s1.id=s2.id+1 and s1.id%2=0)
union all
select s1.id, s1.student
from Seat s1
group by id
having id%2=1 and id=(select max(id) from Seat)
order by id
;

/* Write your PL/SQL query statement below */
select s1.id, coalesce(s2.student, s1.student) student
from Seat s1 left join Seat s2
on (s1.id+1 + 1) - BITAND(s1.id+1, 1) * 2-1 = s2.id
order by s1.id
;