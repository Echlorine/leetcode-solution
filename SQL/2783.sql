# Write your MySQL query statement below
with t as (
    select flight_id, count(*) passenger_cnt from Passengers
    group by 1
)
select f.flight_id, if(capacity > ifnull(passenger_cnt, 0), ifnull(passenger_cnt, 0), capacity) booked_cnt,
if (capacity > ifnull(passenger_cnt, 0), 0, ifnull(passenger_cnt, 0) - capacity) waitlist_cnt
from Flights f left join t
on f.flight_id = t.flight_id
order by 1
;