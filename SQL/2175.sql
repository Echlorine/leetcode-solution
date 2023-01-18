# Write your MySQL query statement below
select team_id, name, cast(old_rk as signed)-cast(new_rk as signed) rank_diff from (
    select t.team_id, name,
    rank() over (order by points desc, name) old_rk,
    rank() over (order by points_change+points desc, name) new_rk
    from TeamPoints t join PointsChange p on t.team_id=p.team_id
) t
;