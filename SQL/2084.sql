# Write your MySQL query statement below
select distinct a.*
from Orders as a left join Orders as b
on a.customer_id=b.customer_id and a.order_type<>b.order_type
where b.order_type is null or b.order_type=1
;