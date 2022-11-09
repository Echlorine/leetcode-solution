# Write your MySQL query statement below
with temp as (
    select customer_id, o.product_id,
    sum(if(date_format(order_date,'%Y-%m')='2020-06',quantity*price,0)) `sum6_cost`,
    sum(if(date_format(order_date,'%Y-%m')='2020-07',quantity*price,0)) `sum7_cost`
    from Orders o join Product p on o.product_id=p.product_id
    group by 1
)
select t.customer_id, c.name
from Customers c join temp t
on c.customer_id=t.customer_id
where t.sum6_cost>=100 and t.sum7_cost>=100
;