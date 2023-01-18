# Write your MySQL query statement below
select person_id, concat(name, "(", substring(profession, 1, 1), ")") as name
from Person
order by 1 desc
;