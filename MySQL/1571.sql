# Write your MySQL query statement below
select w.name as 'WAREHOUSE_NAME', sum(w.units*p.Width*p.Length*p.Height) as VOLUME
from Warehouse w join Products p
on w.product_id=p.product_id
group by w.name
;