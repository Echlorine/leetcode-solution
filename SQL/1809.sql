# Write your MySQL query statement below
with temp as (
    select session_id from Playback p join Ads a
    where p.customer_id=a.customer_id and p.start_time<=a.timestamp and p.end_time>=a.timestamp
)
select session_id from Playback where session_id not in (select * from temp)
;