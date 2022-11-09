# Write your MySQL query statement below
select s.seller_name from
Seller s
left join
(select sale_date, seller_id from Orders where year(sale_date)=2020) o
on s.seller_id=o.seller_id
where o.sale_date is null
order by s.seller_name
;