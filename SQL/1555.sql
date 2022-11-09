# Write your MySQL query statement below
with paid as (
    select paid_by id, sum(amount) paid from Transactions group by paid_by
),
`got` as (
    select paid_to id, sum(amount) got from Transactions group by paid_to
)
select user_id, user_name, credit-ifnull(paid.paid,0)+ifnull(got.got,0) credit, if(credit-ifnull(paid.paid,0)+ifnull(got.got,0)<0,'Yes','No') credit_limit_breached
from Users left join paid on user_id=paid.id left join got on user_id=got.id
;