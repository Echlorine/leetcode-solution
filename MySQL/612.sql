# Write your MySQL query statement below
select min(length) shortest
from (
    select round(sqrt(power(a.x-b.x, 2)+power(a.y-b.y,2)),2) length from Point2D a join Point2D b on (a.x, a.y) <> (b.x, b.y)
) t
;