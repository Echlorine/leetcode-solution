# Write your MySQL query statement below
select t1.team_name home_team, t2.team_name away_team
from Teams t1 join Teams t2
on t1.team_name<>t2.team_name
;