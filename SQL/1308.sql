# Write your MySQL query statement below
select gender, day,
sum(score_points) over (partition by gender order by day rows between unbounded preceding and current row) as total
from Scores;