# Write your MySQL query statement below
select activity from (
    select activity, dense_rank() over (order by nums desc) dk, dense_rank() over (order by nums) rk from (
        select activity, count(*) nums from Friends group by activity
    ) t
) tt
where dk<>1 and rk<>1;