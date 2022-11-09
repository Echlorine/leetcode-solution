# Write your MySQL query statement below
with temp as (
    select player_id, sum(score) score from (
        select first_player player_id, sum(first_score) score from Matches group by first_player
        union all
        select second_player player_id, sum(second_score) score from Matches group by second_player
    ) t
    group by player_id
)
select group_id, player_id from (
    select p.group_id, p.player_id, rank() over (partition by p.group_id order by score desc, p.player_id) rk
    from Players p left join temp t on p.player_id=t.player_id
) tt
where rk=1
;