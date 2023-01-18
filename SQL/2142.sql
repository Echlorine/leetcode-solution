# Write your MySQL query statement below
select bus_id, count(passenger_id) passengers_cnt from (
    select *, lag(arrival_time,1,0) over(order by arrival_time) last_time
    from Buses
) t left join Passengers p
on p.arrival_time>t.last_time and p.arrival_time<=t.arrival_time
group by 1
order by 1
;