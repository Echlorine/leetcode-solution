# Write your MySQL query statement below
with temp as (
    select customer_id, order_date, customer_pref_delivery_date, rank() over (partition by customer_id order by order_date) rk from Delivery
)
select round(count(if(order_date=customer_pref_delivery_date,0,null))/count(*)*100,2) immediate_percentage
from temp
where rk=1
;

/* Write your PL/SQL query statement below */
with temp as (
    select delivery_id, customer_id, order_date, customer_pref_delivery_date,
    rank() over(partition by customer_id order by order_date) rk
    from Delivery
)
select round(
    sum(case when order_date=customer_pref_delivery_date then 1 else 0 end) * 100
    /
    count(*), 2
) immediate_percentage from temp
where rk = 1
;