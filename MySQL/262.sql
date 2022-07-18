select t1.request_at as Day,
round(if(cancelled_num is null, 0, cancelled_num)/all_num,2) as 'Cancellation Rate'
from
(
    (
        select request_at, count(id) as all_num from Trips
        where client_id in (select users_id from Users where banned='No') and driver_id in (select users_id from Users where banned='No')
        group by request_at
        having request_at between '2013-10-01' and '2013-10-03'
    ) t1
    left join
    (
        select request_at, count(id) as cancelled_num from Trips
        where client_id in (select users_id from Users where banned='No') and driver_id in (select users_id from Users where banned='No') and status!='completed'
        group by request_at
        having request_at between '2013-10-01' and '2013-10-03'
    ) t2
    on t1.request_at=t2.request_at
)
;