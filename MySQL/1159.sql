# Write your MySQL query statement below
with temp as (
    select seller_id, i.item_brand, rank() over (partition by seller_id order by order_date) rk
    from Orders o join Items i on o.item_id=i.item_id
)
select user_id seller_id, 'no' 2nd_item_fav_brand from Users
where user_id not in (select seller_id from temp where rk=2)
union
select seller_id, if(u.favorite_brand=t.item_brand, 'yes', 'no') 2nd_item_fav_brand
from Users u join temp t on u.user_id=t.seller_id
where t.rk=2
;