# Write your MySQL query statement below
select first_name, type, SEC_TO_TIME(duration) as duration_formatted from (
(select first_name, type, sum(duration) as duration
from Contacts c join Calls
on c.id=Calls.contact_id
where type='incoming'
group by c.id
order by 3 desc
limit 3)
union
(select first_name, type, sum(duration) as duration
from Contacts c join Calls
on c.id=Calls.contact_id
where type='outgoing'
group by c.id
order by 3 desc
limit 3)
) t
;