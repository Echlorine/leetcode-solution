# Write your MySQL query statement below
select first_col, second_col
from (
    select first_col, row_number() over(order by first_col) rk from Data
) t1 join (
    select second_col, row_number() over (order by second_col desc) rk from Data
) t2
on t1.rk=t2.rk
;