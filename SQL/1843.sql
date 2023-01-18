# Write your MySQL query statement below
with t as (
    select account_id,
    date_format(`day`, "%Y-%m-01") `month`,
    sum(if(type='Creditor', amount, 0)) income
    from Transactions
    group by 1, 2
)
select distinct t1.account_id
from (t t1 join t t2
on t1.account_id=t2.account_id and timestampdiff(month, t1.`month`, t2.`month`)=1)
join Accounts a on t1.account_id=a.account_id
where t1.income>max_income and t2.income>max_income
;