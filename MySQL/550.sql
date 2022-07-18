# Write your MySQL query statement below
select round(
    (select count(distinct a1.player_id) from Activity a1 join Activity a2 on a1.player_id=a2.player_id and a2.event_date-a1.event_date=1
where (a1.player_id, a1.event_date) in (select player_id, min(event_date) as event_date from Activity group by player_id))
    /
    (select count(distinct player_id) from Activity),
    2
)
as fraction
;