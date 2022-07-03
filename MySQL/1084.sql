# Write your MySQL query statement below
select Product.product_id, Product.product_name
from Product join Sales
on Product.product_id=Sales.product_id
group by Sales.product_id
having datediff(min(Sales.sale_date), '2019-01-01')>=0 and datediff(max(Sales.sale_date), '2019-03-31')<=0
;