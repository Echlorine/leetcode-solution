# Write your MySQL query statement below
select p.product_name, sum(unit) unit
from Orders o join Products p on o.product_id=p.product_id
where date_format(order_date,'%Y-%m')='2020-02'
group by o.product_id
having sum(unit)>=100
;

/* Write your PL/SQL query statement below */
select p.product_name, sum(o.unit) unit
from Products p join Orders o
on p.product_id = o.product_id
where order_date between to_date('2020-02-01', 'yyyy-mm-dd') and to_date('2020-02-29', 'yyyy-mm-dd')
group by p.product_id, product_name
having sum(o.unit)>=100
;