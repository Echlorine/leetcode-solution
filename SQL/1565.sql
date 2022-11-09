# Write your MySQL query statement below
select date_format(order_date,'%Y-%m') month, count(distinct order_id) order_count, count(distinct customer_id) customer_count from Orders
where invoice>20
group by date_format(order_date,'%Y-%m')
;