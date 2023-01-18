# Write your MySQL query statement below
select distinct user_id from (
    select *, lag(purchase_date,1) over (partition by user_id order by purchase_date) last_date from Purchases
) t
where datediff(purchase_date, last_date)<=7
;