# Write your MySQL query statement below
with t as (
    select customer_id, lag(customer_id) over() pre_customer,
    transaction_date, lag(transaction_date) over() pre_date
    from Transactions
    order by 1,3
),
tt as (
    select customer_id,
    @temp:=case
    when customer_id=ifnull(pre_customer, customer_id-1) and datediff(transaction_date, ifnull(pre_date, date_sub(transaction_date,INTERVAL 1 day)))=1
    then ifnull(@temp, 0)+1
    else 1
    end nums
    from t
)
select customer_id from tt
where nums=(select max(nums) from tt)
;