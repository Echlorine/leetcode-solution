# Write your MySQL query statement below
with t as (
    select user1_id, user2_id from (
        select distinct l1.user_id user1_id, l2.user_id user2_id
        from Listens l1 join Listens l2
        on l1.user_id<l2.user_id and l1.song_id=l2.song_id and l1.`day`=l2.`day`
        group by 1, 2, l1.`day`
        having count(distinct l1.song_id)>=3
    ) temp
    where (user1_id, user2_id) not in (select * from Friendship)
)
select user1_id user_id, user2_id recommended_id from t
union
select user2_id, user1_id from t
;