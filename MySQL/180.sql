# Write your MySQL query statement below
select distinct a.num as ConsecutiveNums
from Logs as a join Logs as b
on a.Id=b.Id-1 and a.Num=b.Num
join Logs as c
on a.Id=c.Id-2 and a.Num=c.Num
;

# Write your MySQL query statement below
select distinct a.num as ConsecutiveNums
from Logs as a, Logs as b, Logs as c
where a.Id=b.Id-1 and a.Num=b.Num and a.Id=c.Id-2 and a.Num=c.Num
;