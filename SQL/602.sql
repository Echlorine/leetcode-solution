# Write your MySQL query statement below
with friends as (
    select requester_id, accepter_id, accept_date from RequestAccepted
    union all
    select accepter_id as requester_id, requester_id as accepter_id, accept_date from RequestAccepted
),
temp as (
    select requester_id, count(*) as num from friends
    group by requester_id
)
select requester_id as id, num from temp
where num=(select max(num) from temp);

with friends as (
    select requester_id, accepter_id, accept_date from RequestAccepted
    union all
    select accepter_id as requester_id, requester_id as accepter_id, accept_date from RequestAccepted
)
select requester_id as id, count(*) as num from friends
group by requester_id
order by num desc
limit 0,1
;