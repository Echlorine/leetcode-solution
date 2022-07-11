# Write your MySQL query statement below
select o.customer_id, c.customer_name
from Orders o join Customers c using(customer_id)
group by customer_id
having sum(product_name='A')>0 and sum(product_name='B')>0 and sum(product_name='C')=0
;