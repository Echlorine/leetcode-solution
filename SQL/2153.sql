# Write your MySQL query statement below
with t as (
    select bus_id, b.arrival_time, capacity,
    count(passenger_id) remain_num
    from Buses b left join Passengers p
    on p.arrival_time<=b.arrival_time
    group by 1
    order by b.arrival_time
)
# temp 已经上车的总人数
select bus_id, temp-lag(temp,1,0) over(order by arrival_time) passengers_cnt
from (
    select bus_id, arrival_time,
    @temp:=ifnull(@temp,0)+if(capacity<remain_num-ifnull(@temp,0), capacity, remain_num-ifnull(@temp,0)) temp
    from t
) tt
order by 1
;


# Write your MySQL query statement below
with t as (
    select bus_id, capacity,
    count(passenger_id) remain_num
    from Buses b left join Passengers p
    on p.arrival_time<=b.arrival_time
    group by 1
    order by b.arrival_time
)
# temp 已经上车的总人数
select bus_id, CONVERT(num, UNSIGNED INTEGER) passengers_cnt from (
    select bus_id,
    if(capacity<remain_num-@temp, capacity, remain_num-@temp) num,
    @temp:=@temp+if(capacity<remain_num-@temp, capacity, remain_num-@temp) temp
    from t, (SELECT @temp:=0) init
) tt
order by 1
;