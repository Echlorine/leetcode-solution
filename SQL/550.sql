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

/* Write your PL/SQL query statement below */
with t as (
    select player_id, min(event_date) start_date from Activity group by player_id
)
select round(count(a.player_id) / count(t.player_id), 2) fraction from Activity a right join t
on a.player_id = t.player_id and a.event_date - t.start_date = 1
;