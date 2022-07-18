# Write your MySQL query statement below
select school_id, if(min(score) is null, -1, min(score)) as score
from Schools left join Exam
on student_count<=capacity
group by school_id
;