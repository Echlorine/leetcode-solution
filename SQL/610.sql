# Write your MySQL query statement below
select *, if(x+y>z && x+z>y && y+z>x, "Yes", "No") triangle
from Triangle;

# Write your MySQL query statement below
select *,
case 
    when x+y<=z or x+z<=y or y+z<=x Then "No"
    else "Yes"
end triangle
from Triangle;

/* Write your PL/SQL query statement below */
select x, y, z,
case
when x + y > z and x + z > y and y + z > x then 'Yes'
else 'No'
end triangle
from Triangle
;