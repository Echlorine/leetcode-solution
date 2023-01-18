# Write your MySQL query statement below
select user_id, sum(s.quantity*p.price) spending
from Sales s join Product p on s.product_id=p.product_id
group by user_id
order by 2 desc, 1
;