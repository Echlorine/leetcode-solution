# Write your MySQL query statement below
select p.name, ifnull(sum(i.rest),0) rest, ifnull(sum(i.paid),0) paid, ifnull(sum(i.canceled),0) canceled, ifnull(sum(i.refunded),0) refunded
from Invoice i right join Product p on i.product_id=p.product_id
group by p.product_id
order by 1
;