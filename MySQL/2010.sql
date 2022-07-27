# Write your MySQL query statement below
with temp as (
    select employee_id, experience,
    sum(salary) over (partition by experience order by salary rows between unbounded preceding and current row) as cost
    from Candidates
)
select employee_id from temp where experience='Senior' and cost<=70000
union all
select employee_id from temp
where experience='Junior'and cost<=70000-(
    select if(max(cost)<=70000, max(cost),0) remain from temp where experience='Senior' and cost<=70000)