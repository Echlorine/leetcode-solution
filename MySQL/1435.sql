# Write your MySQL query statement below
select '[0-5>' as bin, count(*) as total from Sessions where duration<300
union all
select '[5-10>' as bin, count(*) as total from Sessions where duration>=300 and duration<600
union all
select '[10-15>' as bin, count(*) as total from Sessions where duration>=600 and duration<900
union all
select '15 or more' as bin, count(*) as total from Sessions where duration>=900