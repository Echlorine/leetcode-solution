# Write your MySQL query statement below
with a as (
    select date_format(trans_date,'%Y-%m') month, country, amount, 1 flag
    from Transactions
    where state='approved'
    union all
    select date_format(c.trans_date,'%Y-%m') month, t.country, t.amount, 0 flag
    from Chargebacks c join Transactions t on c.trans_id=t.id
)
select a.month, a.country,
count(if(flag=1,1,null)) approved_count, sum(if(flag=1,amount,0)) approved_amount,
count(if(flag=0,1,null)) chargeback_count, sum(if(flag=0,amount,0)) chargeback_amount
from a group by month,country
;