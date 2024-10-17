# Write your MySQL query statement below
select CEIL(minute/6) interval_no, sum(order_count) total_orders from Orders
group by 1
order by 1
;