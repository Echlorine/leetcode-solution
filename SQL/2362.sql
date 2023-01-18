# Write your MySQL query statement below
select b.product_id, b.quantity, b.quantity*p.price price
from (Purchases b join Products p on b.product_id=p.product_id) join (
    select invoice_id, rank() over (order by sum(b.quantity*p.price) desc, invoice_id) rk
    from Purchases b join Products p
    on b.product_id=p.product_id
    group by 1
) t
on t.invoice_id=b.invoice_id
where t.rk=1
;