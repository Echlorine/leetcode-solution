# Write your MySQL query statement below
select s1.sale_date, s1.sold_num - s2.sold_num as diff
from Sales s1 join Sales s2
on datediff(s1.sale_date,s2.sale_date)=0 and s1.fruit='apples' and s2.fruit='oranges'
;