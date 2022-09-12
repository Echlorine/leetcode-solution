# Write your MySQL query statement below
with temp as (
    select product_id, min(year) first_year from Sales group by product_id
)
select t.product_id, t.first_year, s.quantity, s.price
from temp t join Sales s on t.product_id=s.product_id and t.first_year=s.year
;