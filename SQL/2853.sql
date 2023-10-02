# Write your MySQL query statement below
select abs(
    (select max(salary) from Salaries where department='Marketing')
    -
    (select max(salary) from Salaries where department='Engineering')
) salary_difference
;