# Write your MySQL query statement below
select player_id, player_name,
sum(Wimbledon=player_id)+sum(Fr_open=player_id)+sum(US_open=player_id)+sum(Au_open=player_id) as grand_slams_count
from Players join Championships
group by player_id
having grand_slams_count>0
;