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