# Write your MySQL query statement below
select class from Courses
group by class
having count(student)>4
;

/* Write your PL/SQL query statement below */
select class from Courses c
group by class
having count(1) >= 5
;