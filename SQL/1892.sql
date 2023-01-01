# Write your MySQL query statement below
with temp as (
    select user1_id user_id, user2_id friend_id, l.page_id from (
        select * from Friendship
        union all
        select user2_id, user1_id from Friendship
    ) t join Likes l on t.user2_id=l.user_id
)
select user_id, page_id, count(*) friends_likes from temp t
where not exists (
    select *
    from Likes
    where user_id=t.user_id
    and page_id=t.page_id
)
group by user_id, page_id
;