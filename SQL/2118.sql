# Write your MySQL query statement below
select concat(GROUP_CONCAT(concat(f,p) order by `power` desc SEPARATOR ''),'=0') equation
from (
    select `power`,
    case
    when factor>=0 then concat('+', factor)
    else factor
    end f,
    case `power`
    when 0 then ''
    when 1 then 'X'
    else concat('X^', `power`)
    end p
    from Terms
) t
;