# Write your MySQL query statement below
with recursive temp as (
    select 1 as n
    union all
    select n+1 from temp where n<100
)
select n as ids from temp
where n not in (select customer_id from Customers)
and n<(select max(customer_id) from Customers)
;