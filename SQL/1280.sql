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

/* Write your PL/SQL query statement below */
select st.student_id, st.student_name, sb.subject_name, count(e.subject_name) attended_exams
from Students st cross join Subjects sb
left join Examinations e
on st.student_id=e.student_id and sb.subject_name = e.subject_name
group by st.student_id, st.student_name, sb.subject_name
order by student_id, subject_name
;