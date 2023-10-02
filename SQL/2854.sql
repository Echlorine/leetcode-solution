# Write your MySQL query statement below
select s1.user_id, s1.steps_date, round((s1.steps_count + s2.steps_count + s3.steps_count) / 3, 2) rolling_average
from Steps s1 join Steps s2 join Steps s3
on DATEDIFF(s1.steps_date, s2.steps_date) = 1 and s1.user_id = s2.user_id and DATEDIFF(s1.steps_date, s3.steps_date) = 2 and s1.user_id = s3.user_id
order by 1, 2
;