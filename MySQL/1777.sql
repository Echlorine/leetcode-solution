# Write your MySQL query statement below
select product_id,
sum(if(store='store1', price, null)) store1,
sum(if(store='store2', price, null)) store2,
sum(if(store='store3', price, null)) store3
from Products
group by product_id
;