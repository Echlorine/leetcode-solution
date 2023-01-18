# Write your MySQL query statement below
with t as (
    select product_id, count(*) cnt, year(purchase_date) purchase_year
    from Orders
    group by 1,3
    having cnt>=3
)
select distinct t1.product_id
from t t1 join t t2
on t1.product_id=t2.product_id and t1.purchase_year-t2.purchase_year=1
;