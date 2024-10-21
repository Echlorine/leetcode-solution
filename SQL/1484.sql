# Write your MySQL query statement below
select
    sell_date,
    count(distinct product) as num_sold,
    GROUP_CONCAT(distinct product) as products
from
    activities
group by sell_date
order by sell_date
;

/* Write your PL/SQL query statement below */
select
    to_char(sell_date) sell_date,
    count(distinct product) num_sold,
    listagg(product, ',') within group(order by product) products
from (select distinct sell_date, product from Activities) t
group by sell_date
order by sell_date
;