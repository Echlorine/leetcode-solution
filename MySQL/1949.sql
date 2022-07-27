# Write your MySQL query statement below
select user1_id, user2_id, count(commen_id) as common_friend
from (
    select f1.user1_id user1_id, f2.user1_id user2_id, f2.user2_id commen_id
    from Friendship f1 join Friendship f2
    on f1.user2_id=f2.user2_id and f1.user1_id<f2.user1_id
    union all
    select f1.user2_id user1_id, f2.user2_id user2_id, f2.user1_id commen_id
    from Friendship f1 join Friendship f2
    on f1.user1_id=f2.user1_id and f1.user2_id<f2.user2_id
    union all
    select f1.user2_id user1_id, f2.user1_id user2_id, f2.user2_id commen_id
    from Friendship f1 join Friendship f2
    on f1.user1_id=f2.user2_id and f1.user2_id<f2.user1_id
    union all
    select f1.user1_id user1_id, f2.user2_id user2_id, f2.user1_id commen_id
    from Friendship f1 join Friendship f2
    on f1.user2_id=f2.user1_id and f1.user1_id<f2.user2_id
) t
where (user1_id,user2_id) in (
    select * from Friendship
)
group by user1_id, user2_id
having common_friend>2
;