# Write your MySQL query statement below
select min(b.x-a.x) shortest from point a join point b on b.x>a.x
;