# Write your MySQL query statement below
with recursive temp as (
    select 1 week_of_month, '2023-11-03' purchase_date, 0 amount_spend
    union all
    select t.week_of_month + 1, DATE_ADD(t.purchase_date, INTERVAL 7 day), amount_spend from temp t
    where week_of_month < 4
)
select week_of_month, t.purchase_date, sum(ifnull(p.amount_spend + t.amount_spend, 0)) total_amount
from Purchases p right join temp t
on p.purchase_date=t.purchase_date
group by 1
order by 1
;