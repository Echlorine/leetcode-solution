# Write your MySQL query statement below
with temp as (
    select distinct follower from follow
)
select followee follower, count(followee) num from temp t join follow f on t.follower=f.followee group by followee order by followee;