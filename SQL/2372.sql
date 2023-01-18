# Write your MySQL query statement below
select a.salesperson_id, a.name, ifnull(sum(s.price),0) total from
(Customer c join Sales s on c.customer_id=s.customer_id)
right join Salesperson a on a.salesperson_id=c.salesperson_id
group by 1
;