# Write your MySQL query statement below
with a as (
    select count(distinct post_id) num, action_date from Actions where extra='spam' group by action_date
),
b as (
    select distinct r.post_id, action_date from Actions a join Removals r on a.post_id=r.post_id where extra='spam'
)
select round(avg(avg_num)*100,2) average_daily_percent from (
    select count(b.post_id)/a.num avg_num from a left join b on a.action_date=b.action_date group by a.action_date
) t
;