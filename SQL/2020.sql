# Write your MySQL query statement below
with temp as(
    select account_id from Subscriptions
    where year(start_date)='2021' or year(end_date)='2021'
)
select count(*) accounts_count from temp
where not exists
(select account_id from Streams s where temp.account_id=s.account_id and year(stream_date)='2021')
;