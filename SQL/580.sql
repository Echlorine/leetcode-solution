# Write your MySQL query statement below
select dept_name, if(student_number is null, 0, student_number) as student_number
from Department left join
(
    select distinct dept_id, count(dept_id) over(partition by dept_id) as student_number from Student
) t
on Department.dept_id=t.dept_id
order by student_number desc, dept_name
;

# Write your MySQL query statement below
select dept_name, count(student_id) student_number from
Student s right join Department d
on s.dept_id = d.dept_id
group by d.dept_id
order by 2 desc, 1
;