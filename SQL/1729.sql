# Write your MySQL query statement below
select user_id, count(follower_id) as followers_count
from Followers
group by user_id
order by user_id
;

/* Write your PL/SQL query statement below */
select user_id, count(follower_id) followers_count from Followers f
group by user_id
order by user_id
;