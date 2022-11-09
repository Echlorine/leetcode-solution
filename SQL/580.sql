# Write your MySQL query statement below
select dept_name, if(student_number is null, 0, student_number) as student_number
from Department left join
(
    select distinct dept_id, count(dept_id) over(partition by dept_id) as student_number from Student
) t
on Department.dept_id=t.dept_id
order by student_number desc, dept_name
;