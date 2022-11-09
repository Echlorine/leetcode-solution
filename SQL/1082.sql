# Write your MySQL query statement below
with temp as (
    select seller_id, sum(price) total_price from Sales group by seller_id
)
select seller_id from temp 
where total_price = (select max(total_price) from temp)
;