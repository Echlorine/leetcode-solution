# Write your MySQL query statement below
with a as (
    select player_id, min(event_date) as event_date from Activity
    group by player_id
),
b as (
    select a.*, if(datediff(t.event_date,a.event_date)=1,1,0) as relogin
    from a join Activity t
    on a.player_id=t.player_id
)
select distinct event_date as install_dt,
count(distinct player_id) as installs,
round(sum(relogin)/count(distinct player_id),2) as Day1_retention
from b
group by event_date;