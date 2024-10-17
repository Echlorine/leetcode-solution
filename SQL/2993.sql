# Write your MySQL query statement below
select FLOOR((DAYOFMONTH(purchase_date) - 1) / 7) + 1 week_of_month, purchase_date, sum(amount_spend) total_amount
from Purchases
where dayofweek(purchase_date) = 6
group by 1
order by 1
;