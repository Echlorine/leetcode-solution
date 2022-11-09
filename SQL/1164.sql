# Write your MySQL query statement below
select product_id, new_price as price from Products 
where (product_id,change_date) in (select product_id, max(change_date) from Products where datediff(change_date,'2019-08-16')<=0 group by product_id)
union all
select distinct product_id, 10 as price from Products 
where product_id not in (select product_id from Products where datediff(change_date,'2019-08-16')<=0 group by product_id)
;