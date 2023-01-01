# Write your MySQL query statement below
select count(distinct customer_id) rich_count
from Store
where amount>500
;