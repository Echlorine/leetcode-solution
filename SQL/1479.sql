# Write your MySQL query statement below
with temp as (
    select item_category Category,
    if(datediff(order_date, '2020-06-01')%7=0, quantity, 0) Monday,
    if(datediff(order_date, '2020-06-01')%7=1, quantity, 0) Tuesday,
    if(datediff(order_date, '2020-06-01')%7=2, quantity, 0) Wednesday,
    if(datediff(order_date, '2020-06-01')%7=3, quantity, 0) Thursday,
    if(datediff(order_date, '2020-06-01')%7=4, quantity, 0) Friday,
    if(datediff(order_date, '2020-06-01')%7=5, quantity, 0) Saturday,
    if(datediff(order_date, '2020-06-01')%7=6, quantity, 0) Sunday
    from Items i left join Orders o on i.item_id=o.item_id
)
select Category, sum(Monday) Monday, sum(Tuesday) Tuesday, sum(Wednesday) Wednesday, sum(Thursday) Thursday, sum(Friday) Friday, sum(Saturday) Saturday, sum(Sunday) Sunday
from temp group by Category
order by Category
;