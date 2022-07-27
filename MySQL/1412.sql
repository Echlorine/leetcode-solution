# Write your MySQL query statement below
select t.student_id, s.student_name from (
    select exam_id, student_id,
    score=max(score) over (partition by exam_id) as max_flag,
    score=min(score) over (partition by exam_id) as min_flag
    from Exam
) t join Student s
on s.student_id=t.student_id
group by s.student_id
having sum(max_flag)+sum(min_flag)=0
order by s.student_id
;