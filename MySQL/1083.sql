# Write your MySQL query statement below
with t1 as (
    select buyer_id from Sales s join Product p on s.product_id=p.product_id where product_name="S8"
),
t2 as (
    select buyer_id from Sales s join Product p on s.product_id=p.product_id where product_name="iPhone"
)
select distinct buyer_id from t1 where buyer_id not in (select * from t2)
;