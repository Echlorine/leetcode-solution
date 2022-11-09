# Write your MySQL query statement below
select customer_id, t.product_id, product_name
from (
    select customer_id, product_id,
    rank() over (partition by customer_id order by count(product_id) desc) as `rank`
    from Orders
    group by customer_id, product_id
) t
join
Products p
on t.product_id=p.product_id
where `rank`=1
;