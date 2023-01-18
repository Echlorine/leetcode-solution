# Write your MySQL query statement below
with t as (
    select player_id, lag(player_id) over() pre_id, match_day, result from Matches
    order by 1,3
)
select player_id, max(streak) longest_streak from (
    select player_id,
    @temp:=case
    when result<>'Win' then 0
    when result='Win' and player_id=pre_id then ifnull(@temp,0)+1
    else 1
    end streak
    from t
) tt
group by 1
;