# Write your MySQL query statement below
with temp as (
    select account_id, day,
    case type
    when 'Deposit' then amount
    else -amount
    end
    amount
    from Transactions
)
select account_id, day,
sum(amount) over (partition by account_id order by day rows between unbounded preceding and current row) balance
from temp
;