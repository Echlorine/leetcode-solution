# Write your MySQL query statement below
select t.student_id, t.course_id, t.grade from
(select student_id, course_id, grade, ROW_NUMBER() OVER(partition by student_id order by grade desc, course_id) as `rank`
from Enrollments) t
where t.rank=1
;