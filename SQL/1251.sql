# Write your MySQL query statement below
select p.product_id, Round(ifnull(sum(p.price*u.units)/sum(u.units),0),2) as average_price
from Prices p left join UnitsSold u
on p.product_id=u.product_id and u.purchase_date between p.start_date and p.end_date
group by p.product_id
;

/* Write your PL/SQL query statement below */
select p.product_id, round(nvl(sum(p.price * u.units) / sum(u.units),0), 2) average_price
from Prices p left join UnitsSold u
on p.product_id = u.product_id
and u.purchase_date >= p.start_date
and u.purchase_date <= p.end_date
group by p.product_id
;