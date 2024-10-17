# Write your MySQL query statement below
with recursive weeks as (
    select 1 as week_of_month
    union all
    select week_of_month + 1 from weeks where week_of_month < 4
), m as (
    select 'Premium' as membership
    union
    select 'VIP'
), t as (
    select WEEK(purchase_date) - WEEK('2023-11-01') + 1 AS week_of_month, u.membership, sum(p.amount_spend) total_amount
    from Purchases p join Users u on p.user_id=u.user_id
    where dayofweek(purchase_date)=6 and u.membership<>'Standard'
    group by week_of_month, membership
)
select p.*, ifnull(t.total_amount, 0) total_amount from t right join (select * from weeks join m) p
on t.week_of_month=p.week_of_month and t.membership=p.membership
order by 1, 2
;