# Write your MySQL query statement below
select extra report_reason, count(distinct post_id) report_count from Actions
where action_date='2019-07-04' and action='report'
group by extra
having extra is not null && report_count>0
;