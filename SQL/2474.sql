# Write your MySQL query statement below
with t as (
    select customer_id, year(order_date) order_year,
    lag(year(order_date)) over(partition by customer_id order by year(order_date)) last_year,
    sum(price) price,
    lag(sum(price)) over(partition by customer_id order by year(order_date)) last_price
    from Orders
    group by 1,2
)
select distinct customer_id from t
where customer_id not in (
    select customer_id from t
    where last_year is not null and (order_year-last_year!=1 or price<=last_price)
)
;