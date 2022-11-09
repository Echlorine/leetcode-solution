# Write your MySQL query statement below
with pe as (
    select * from
    (select 'IOS' platform union all select 'Android' union all select 'Web') p
    join
    (select 'Programming' experiment_name union all select 'Sports' union all select 'Reading') t
)
select pe.*, count(e.experiment_id) num_experiments
from pe left join Experiments e
on pe.platform=e.platform and pe.experiment_name=e.experiment_name
group by pe.platform, pe.experiment_name
;