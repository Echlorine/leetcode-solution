# Write your MySQL query statement below
with temp as (
    select *,
    row_number() over (partition by user_id order by transaction_date) nk
    from Transactions
), t as (
    select user_id, spend, transaction_date, nk, dense_rank() over(partition by user_id order by spend) k
    from temp
    where nk < 4
)
select user_id, spend third_transaction_spend, transaction_date third_transaction_date
from t
where nk = 3 and k = 3
order by 1
;