# Write your MySQL query statement below
with temp as (
    select "failed" type, fail_date as date from Failed where year(fail_date)=2019
    union all
    select "succeeded" type, success_date as date from Succeeded where year(success_date)=2019
    order by date
)
select type as period_state, min(date) as start_date, max(date) as end_date
from (
    select *, subdate(date, row_number() over (partition by type order by date)) as diff from temp
) t
group by type, diff
order by start_date
;