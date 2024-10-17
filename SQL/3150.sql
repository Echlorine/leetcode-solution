# Write your MySQL query statement below
select tweet_id from Tweets
where
    content REGEXP '.*@.*@.*@.*@.*' or
    content REGEXP '.*#.*#.*#.*#.*' or
    length(content) > 140
order by 1
;


# Write your MySQL query statement below
select tweet_id from Tweets
where
    length(content) > 140 or
    (length(content) - length(replace(content,'#',''))) > 3 or
    (length(content) - length(replace(content,'@',''))) > 3 
order by tweet_id
