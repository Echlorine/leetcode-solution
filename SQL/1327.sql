# Write your MySQL query statement below
select p.product_name, sum(unit) unit
from Orders o join Products p on o.product_id=p.product_id
where date_format(order_date,'%Y-%m')='2020-02'
group by o.product_id
having sum(unit)>=100
;