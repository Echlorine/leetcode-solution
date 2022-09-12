# Write your MySQL query statement below
with temp as (
    select customer_id, order_date, customer_pref_delivery_date, rank() over (partition by customer_id order by order_date) rk from Delivery
)
select round(count(if(order_date=customer_pref_delivery_date,0,null))/count(*)*100,2) immediate_percentage
from temp
where rk=1
;