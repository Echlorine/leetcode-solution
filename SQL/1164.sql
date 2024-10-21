# Write your MySQL query statement below
select product_id, new_price as price from Products 
where (product_id,change_date) in (select product_id, max(change_date) from Products where datediff(change_date,'2019-08-16')<=0 group by product_id)
union all
select distinct product_id, 10 as price from Products 
where product_id not in (select product_id from Products where datediff(change_date,'2019-08-16')<=0 group by product_id)
;

/* Write your PL/SQL query statement below */
with t as (
    select product_id, new_price, rank() over(partition by product_id order by change_date desc) rk
    from Products p
    where change_date <= '2019-08-16'
)
select p.product_id, nvl(t.new_price, 10) price
from Products p left join t
on p.product_id=t.product_id and t.rk=1
group by p.product_id, t.new_price
;