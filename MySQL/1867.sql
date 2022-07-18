# Write your MySQL query statement below
select order_id
from (
    select order_id, max(quantity) as max_quantity
    from OrdersDetails
    group by order_id
    having max_quantity>(
        select max(avg_quantity)
        from (
            select avg(quantity) as avg_quantity from OrdersDetails group by order_id
        ) t
    )
) tt


# Write your MySQL query statement below
select order_id from (
    select order_id, max(quantity)>max(avg(quantity)) over () as base
    from OrdersDetails
    group by order_id
) t
where base=1
;