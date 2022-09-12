# Write your MySQL query statement below
select distinct viewer_id id from Views
group by viewer_id,view_date
having count(distinct article_id)>=2
order by viewer_id
;