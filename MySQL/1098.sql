# Write your MySQL query statement below
with t1 as (
    select * from Books where datediff('2019-06-23', available_from)>30
),
t2 as (
    select book_id, sum(quantity) as num from Orders
    where datediff('2019-06-23',dispatch_date)<=365
    group by book_id having sum(quantity)>=10
)
select book_id, name from t1
where book_id not in (select book_id from t2);