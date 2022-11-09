# Write your MySQL query statement below
# 递归生成月份
with recursive temp as (
    select 1 `month`
    union select `month`+1 from temp where `month`<12
),
# 某月份工作的驾驶员数量
format_drivers as (
    select temp.`month`, count(driver_id) active_drivers
    from temp join Drivers
    on temp.`month`=Month(if (datediff('2020-01-01',join_date)>0,'2020-01-01',join_date))
    where Year(join_date)<=2020
    group by 1
    union all
    select temp.`month`, 0 from temp
    where temp.`month` not in (
        select Month(if (datediff('2020-01-01',join_date)>0,'2020-01-01',join_date)) from Drivers
        where Year(join_date)<=2020
    )
),
# 该月接受的乘车次数
format_rides as (
    select Month(requested_at) `month`, count(*) accepted_rides
    from Rides r join AcceptedRides a on r.ride_id = a.ride_id
    where Year(requested_at)=2020
    group by 1
    union all
    select temp.`month`, 0 from temp
    where temp.`month` not in (
        select Month(requested_at) from Rides r join AcceptedRides a on r.ride_id = a.ride_id
        where Year(requested_at)<=2020
    )
)
select d.`month`,
sum(active_drivers) over (order by `month` rows between unbounded preceding and current row) active_drivers,
accepted_rides
from format_drivers d join format_rides r on d.`month`=r.`month`
;