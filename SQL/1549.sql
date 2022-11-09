# Write your MySQL query statement below
select product_name, product_id, order_id, order_date
from (
    select p.product_name, o.product_id, o.order_id, o.order_date, rank() over (partition by o.product_id order by o.order_date desc) as `rank`
    from Orders o join Products p
    on o.product_id=p.product_id
) t
where `rank`=1
order by product_name, product_id, order_id
;