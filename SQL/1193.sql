# Write your MySQL query statement below
select
DATE_FORMAT(trans_date, '%Y-%m') as month,
country,
count(state) as trans_count,
sum(if(state='approved', 1, 0)) as approved_count,
sum(amount) as trans_total_amount,
sum(if(state='approved', amount, 0)) as approved_total_amount
from Transactions
group by country, DATE_FORMAT(trans_date, '%Y-%m');

/* Write your PL/SQL query statement below */
select substr(trans_date, 1, 7) month, country,
count(id) trans_count,
sum(case state when 'approved' then 1 else 0 end) approved_count,
sum(amount) trans_total_amount,
sum(case state when 'approved' then amount else 0 end) approved_total_amount
from Transactions
group by substr(trans_date, 1, 7), country
;