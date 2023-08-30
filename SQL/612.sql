# Write your MySQL query statement below
select min(length) shortest
from (
    select round(sqrt(power(a.x-b.x, 2)+power(a.y-b.y,2)),2) length from Point2D a join Point2D b on (a.x, a.y) <> (b.x, b.y)
) t
;

# Write your MySQL query statement below
select round(min(sqrt(pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2))), 2) shortest
from Point2D p1 join Point2D p2
on p1.x != p2.x || p1.y != p2.y
;

# Write your MySQL query statement below
select round(min(sqrt(pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2))), 2) shortest
from Point2D p1 join Point2D p2 on
(p1.x <= p2.x AND p1.y < p2.y) or
(p1.x <= p2.x AND p1.y > p2.y) or
(p1.x < p2.x AND p1.y = p2.y)
;