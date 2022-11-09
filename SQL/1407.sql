# Write your MySQL query statement below
select Users.name, if(sum(Rides.distance) is null, 0, sum(Rides.distance)) as travelled_distance
from Users left join Rides
on Users.id=Rides.user_id
group by Users.id
order by travelled_distance desc, Users.name
;