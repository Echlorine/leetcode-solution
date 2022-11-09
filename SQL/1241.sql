# Write your MySQL query statement below
select post_id, count(distinct sub_id) number_of_comments from 
(select distinct sub_id post_id from Submissions where parent_id is null) t left join Submissions s
on t.post_id=s.parent_id
group by t.post_id
;