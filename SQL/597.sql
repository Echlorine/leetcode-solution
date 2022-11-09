# Write your MySQL query statement below
select round(
    ifnull(
    (select count(distinct requester_id, accepter_id) from RequestAccepted) /
    (select count(distinct sender_id, send_to_id) from FriendRequest), 0),
    2
) accept_rate
;