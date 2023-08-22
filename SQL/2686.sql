# Write your MySQL query statement below
select order_date, round(sum(if(customer_pref_delivery_date = order_date, 1, 0)) / count(*) * 100, 2) immediate_percentage
from Delivery
group by 1
order by 1
;