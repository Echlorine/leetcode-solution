# Write your MySQL query statement below
with t as (
    select *, rank() over(order by topping_name) rk from Toppings
)
select CONCAT_WS(',', t1.topping_name, t2.topping_name, t3.topping_name) pizza,
t1.cost + t2.cost + t3.cost total_cost
from t t1 join t t2 join t t3
on t1.rk < t2.rk and t2.rk < t3.rk
order by 2 desc, 1
;