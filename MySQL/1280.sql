# Write your MySQL query statement below
select s.student_id, s.student_name, sb.subject_name,
if(t.counts is null, 0, t.counts) as attended_exams
from
Students s cross join Subjects sb
left join
(
    select distinct student_id, subject_name,
    count(*) over(partition by student_id, subject_name) as counts
    from Examinations
) t
on s.student_id=t.student_id and sb.subject_name=t.subject_name
order by s.student_id, sb.subject_name
;