# Write your MySQL query statement below
select student_id, department_id, round(if(cnt<>1,(rk-1)/(cnt-1)*100,0),2) percentage from (
    select student_id, department_id,
    rank() over(partition by department_id order by mark desc) rk,
    count(*) over(partition by department_id) cnt
    from Students
) t
;