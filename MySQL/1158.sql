# Write your MySQL query statement below
select
Users.user_id as buyer_id,
Users.join_date,
if(temp.order_num is null, 0, temp.order_num) as orders_in_2019
from Users left join (
    select buyer_id, count(item_id) as order_num
    from Orders
    where year(order_date)='2019'
    group by buyer_id
) as temp
on Users.user_id=temp.buyer_id
;