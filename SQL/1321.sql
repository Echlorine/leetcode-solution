# Write your MySQL query statement below
select date_add(t.visited_on, interval 6 day) as visited_on,
sum(amount) as amount,
round(sum(amount)/7, 2) as average_amount
from Customer c join (
    select distinct visited_on
    from Customer
    where date_add(visited_on, interval 6 day)<=(select max(visited_on) as max_date from Customer)
) t
on datediff(c.visited_on, t.visited_on)<=6 and datediff(c.visited_on, t.visited_on)>=0
group by t.visited_on
;

# Write your MySQL query statement below
with t as (
    select distinct visited_on,
        sum(amount) over(order by visited_on range interval 6 day preceding) amount
    from Customer
)
select visited_on, amount, round(amount/7, 2) average_amount from t t1
where exists(
    select 1 from t t2
    where date_sub(t1.visited_on, INTERVAL 6 DAY) = t2.visited_on
)
;

/* Write your PL/SQL query statement below */
with t as (
    select visited_on,
    sum(amount) over (order by visited_on range NUMTODSINTERVAL(6,'day') preceding) amount,
    sum(amount) over (order by visited_on range NUMTODSINTERVAL(6,'day') preceding) / 7 average_amount
    from Customer
)
select distinct to_char(t1.visited_on) visited_on, amount, round(average_amount, 2) average_amount from t t1
where exists (
    select 1 from t t2
    where t1.visited_on - 6 = t2.visited_on
)
order by visited_on
;