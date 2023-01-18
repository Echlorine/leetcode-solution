# Write your MySQL query statement below
with temp as (
    select departure_airport airport_id, arrival_airport, flights_count from Flights
    union all
    select arrival_airport airport_id, departure_airport, flights_count from Flights
)
select airport_id from (
    select airport_id, rank() over (order by sum(flights_count) DESC) as rk
    from temp
    group by 1
) t
where t.rk=1
;