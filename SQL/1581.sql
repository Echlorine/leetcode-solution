# Write your MySQL query statement below
select customer_id,
count(customer_id) as count_no_trans
from Visits
where
visit_id not in(
    select visit_id from Transactions
)
group by customer_id
;

# Write your MySQL query statement below
select Visits.customer_id, count(Visits.visit_id) as count_no_trans 
from Visits left outer join Transactions
on Visits.visit_id  = Transactions.visit_id 
where Transactions.amount is null
group by Visits.customer_id
;

/* Write your PL/SQL query statement below */
select customer_id, count(1) count_no_trans
from Visits v
where not exists
(select visit_id from Transactions t where t.visit_id = v.visit_id)
group by customer_id
;