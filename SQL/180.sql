# Write your MySQL query statement below
select distinct a.num as ConsecutiveNums
from Logs as a join Logs as b
on a.Id=b.Id-1 and a.Num=b.Num
join Logs as c
on a.Id=c.Id-2 and a.Num=c.Num
;

# Write your MySQL query statement below
select distinct l1.Num as ConsecutiveNums
from Logs l1 join Logs l2 join Logs l3
on l1.id=l2.id-1 and l1.Num=l2.Num and l1.id=l3.id-2 and l1.Num=l3.Num
;

/* Write your PL/SQL query statement below */
select distinct num ConsecutiveNums from (
    select id, num, lag(id,2) over(partition by num order by id asc) as preId from Logs
) t
where id - preId = 2
;