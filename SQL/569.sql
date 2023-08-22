# Write your MySQL query statement below
select id, company, salary from (
    select id, company, salary, 
    row_number() over(partition by company order by salary) as rk,
    count(id) over(partition by company)as cnt
    from Employee
) t
where rk>=cnt/2 and rk<=cnt/2+1
;