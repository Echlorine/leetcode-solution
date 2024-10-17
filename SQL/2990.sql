# Write your MySQL query statement below
select user_id from (
    select user_id, count(distinct loan_type) cnt from Loans
    where loan_type="Mortgage" || loan_type="Refinance"
    group by 1
) t
where cnt > 1
order by 1
;