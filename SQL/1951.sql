# Write your MySQL query statement below
select user1_id, user2_id from
(
    select r1.user_id user1_id,
    r2.user_id user2_id,
    dense_rank() over (order by count(*) desc) as `rank`
    from Relations r1 join Relations r2
    on r1.follower_id=r2.follower_id and r1.user_id<r2.user_id
    group by user1_id, user2_id
) t
where `rank`=1
;