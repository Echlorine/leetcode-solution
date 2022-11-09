# Write your MySQL query statement below
with temp as (
    select match_id, host_team, guest_team, host_goals, guest_goals from Matches
    union all
    select match_id, guest_team, host_team, guest_goals, host_goals from Matches
)
select t.team_id,
t.team_name,
if(match_id is null,
0,
sum(
    case
    when host_goals>guest_goals then 3
    when host_goals=guest_goals then 1
    else 0
    end
    )
) as num_points
from Teams t left join temp
on t.team_id=temp.host_team
group by t.team_id
order by num_points desc, t.team_id
;