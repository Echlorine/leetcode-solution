# Write your MySQL query statement below
with t as (
    select t.*, case
    when m.home_team_goals>m.away_team_goals then 3
    when m.home_team_goals=m.away_team_goals then 1
    when m.home_team_goals<m.away_team_goals then 0
    end scores,
    home_team_goals goal_for,
    away_team_goals goal_against
    from Teams t join Matches m
    on t.team_id=m.home_team_id
    union all
    select t.*, case
    when m.home_team_goals<m.away_team_goals then 3
    when m.home_team_goals=m.away_team_goals then 1
    when m.home_team_goals>m.away_team_goals then 0
    end scores,
    away_team_goals goal_for,
    home_team_goals goal_against
    from Teams t join Matches m
    on t.team_id=m.away_team_id
)
select t.team_name, count(*) matches_played, sum(scores) points, sum(goal_for) goal_for, sum(goal_against) goal_against, sum(goal_for-goal_against) goal_diff
from t
group by t.team_id
order by 3 desc, 6 desc, 1
;