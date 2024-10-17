# Write your MySQL query statement below
select N, 
case
when P is NULL then 'Root'
when N not in (select P from Tree where P is not NULL) then 'Leaf'
else 'Inner'
end Type
from Tree
order by 1
;