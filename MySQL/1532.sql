# Write your MySQL query statement below
select name customer_name, t.customer_id, order_id, order_date
from Customers c join (
    select order_id, order_date, customer_id,
    rank() over (partition by customer_id order by order_date desc) as `rank`
    from Orders
    order by customer_id
) t
on c.customer_id=t.customer_id
where `rank`<=3
order by customer_name, customer_id, order_date desc
;