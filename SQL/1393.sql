# Write your MySQL query statement below
select stock_name, sum(if (operation='Buy', -price, price)) as capital_gain_loss
from Stocks
group by stock_name
;

# Write your MySQL query statement below
select stock_name, sum(case operation when 'Buy' then -price else price end) as capital_gain_loss
from Stocks
group by stock_name
;