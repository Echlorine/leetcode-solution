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