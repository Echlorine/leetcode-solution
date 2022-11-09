# Write your MySQL query statement below
select unique_id, name from Employees s left join EmployeeUNI i on s.id=i.id;