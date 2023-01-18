# Write your MySQL query statement below
select city_id, `day`, degree from (
    select *, rank() over (partition by city_id order by degree desc, day) rk from Weather
) t
where t.rk=1
order by 1
;