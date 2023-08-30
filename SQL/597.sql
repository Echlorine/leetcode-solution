# Write your MySQL query statement below
select round(
    ifnull(
    (select count(distinct requester_id, accepter_id) from RequestAccepted) /
    (select count(distinct sender_id, send_to_id) from FriendRequest), 0),
    2
) accept_rate
;

# Write your MySQL query statement below
with t1 as (
    select count(distinct requester_id, accepter_id) num from RequestAccepted
),
t2 as (
    select count(distinct sender_id, send_to_id) num from FriendRequest
)
select round(ifnull(t1.num/ t2.num, 0), 2) accept_rate from t1, t2
;