# Write your MySQL query statement below
with temp as (
    select player_id, min(event_date) event_date from Activity
    group by player_id
)
select a.player_id, a.device_id from
temp t join Activity a
on t.player_id=a.player_id and t.event_date=a.event_date
;

# Write your MySQL query statement below
select player_id, device_id from (
    select player_id, device_id, rank() over (partition by player_id order by event_date) rk
    from Activity
) t
where rk = 1
;