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

/* Write your PL/SQL query statement below */
with t as (
    select requester_id, accepter_id from RequestAccepted
    union all
    select accepter_id, requester_id from RequestAccepted
)
select * from (
    select requester_id id, count(*) num from t
    group by requester_id
    order by num desc
) where rownum = 1
;