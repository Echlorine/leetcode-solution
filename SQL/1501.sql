# Write your MySQL query statement below
select c.name as country
from Person p join Country c
on left(p.phone_number,3)=c.country_code
join Calls
on p.id=Calls.caller_id or p.id=Calls.callee_id
group by c.name
having avg(Calls.duration)>(select avg(duration) from Calls)
;