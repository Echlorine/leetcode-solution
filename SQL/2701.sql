# Write your MySQL query statement below
with t as (
    select customer_id, lag(customer_id, 1, customer_id) over() pre_customer,
    transaction_date, lag(transaction_date, 1, date_sub(transaction_date, INTERVAL 1 day)) over() pre_date,
    amount, lag(amount, 1, amount - 1) over() pre_amount
    from Transactions
    order by 1, 3
)
select customer_id, min(transaction_date) consecutive_start, max(transaction_date) consecutive_end from (
    select customer_id, transaction_date,
    @temp:=case
    when customer_id = pre_customer and datediff(transaction_date, pre_date)=1 and amount > pre_amount
    then ifnull(@temp, 1)
    else ifnull(@temp, 0) + 1
    end tag
    from t
) tt
group by customer_id, tag
having count(*)>=3
;