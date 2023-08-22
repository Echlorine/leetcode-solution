# Write your MySQL query statement below
select distinct user_id from (
    select user_id,
    timestampdiff(day, lag(created_at,1, null) over(partition by user_id order by created_at), created_at) diff
    from Users
) t
where diff <= 7
;