# Write your MySQL query statement below
# 递归生成月份
with recursive temp as (
    select 1 `month`, 1 t
    union select `month`+1, t+1 from temp where `month`<12
),
# 该月接受的乘车信息
format_rides as (
    select sum(a.ride_distance) dis, sum(a.ride_duration) dur, Month(r.requested_at) `month`
    from AcceptedRides a join Rides r
    on a.ride_id=r.ride_id
    where Year(r.requested_at)=2020
    group by 3
)
select `month`,
round(avg(dis) over (rows between current row and 2 following),2) average_ride_distance,
round(avg(dur) over (rows between current row and 2 following),2) average_ride_duration
from (
    select t.`month`, ifnull(r.dis,0) dis, ifnull(r.dur,0) dur from
    temp t left join format_rides r
    on t.`t`=r.`month`
    group by `month`
) tt
limit 0,10
;