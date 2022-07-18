# Write your MySQL query statement below
select distinct country_name, 
case
when avg(weather_state) over(partition by c.country_id)<=15 then 'Cold'
when avg(weather_state) over(partition by c.country_id)>=25 then 'Hot'
else 'Warm'
end weather_type
from Weather join Countries c on Weather.country_id=c.country_id
where month(day)=11;