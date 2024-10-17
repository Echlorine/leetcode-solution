# Write your MySQL query statement below
with t as (
    select *,
    rank() over (partition by state order by fraud_score desc) as rk,
    rank() over (partition by state order by fraud_score desc) / count(*) over(partition by state) as tk
    from Fraud
)
select policy_id, state, fraud_score from t
where rk=1 or tk<=0.05
order by state, fraud_score desc, policy_id
;