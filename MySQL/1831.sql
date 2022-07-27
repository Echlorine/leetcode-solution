# Write your MySQL query statement below
select transaction_id from (
    select transaction_id, day, amount,
    max(amount) over (partition by DATE_FORMAT(day, '%Y-%m-%d')) as max_amount
    from Transactions
) t
where amount=max_amount
order by transaction_id
;

# Write your MySQL query statement below
select transaction_id from (
    select transaction_id, day, amount,
    rank() over (partition by DATE_FORMAT(day, '%Y-%m-%d') order by amount desc) as `rank`
    from Transactions
) t
where `rank`=1
order by transaction_id
;