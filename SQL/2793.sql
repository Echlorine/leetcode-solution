# Write your MySQL query statement below
with t as (
    select passenger_id, flight_id, booking_time,
    rank() over(partition by flight_id order by booking_time) rk
    from Passengers
)
select passenger_id,
case
when rk <= capacity then 'Confirmed'
else 'Waitlist'
end Status
from Flights f right join t
on f.flight_id=t.flight_id
order by 1
;