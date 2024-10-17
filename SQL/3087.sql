# Write your MySQL query statement below
with t as (
    SELECT CONCAT('#', SUBSTRING_INDEX(SUBSTRING_INDEX(tweet, '#', -1), ' ', 1)) hashtag from Tweets
)
select hashtag, count(*) hashtag_count from t
group by 1
order by 2 desc, 1 desc
limit 3
;