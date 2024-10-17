# Write your MySQL query statement below
select author_id as id
from Views
where author_id=viewer_id
group by author_id
order by author_id
;

# Write your MySQL query statement below
select distinct author_id as id
from Views
where author_id=viewer_id
order by author_id
;

/* Write your PL/SQL query statement below */
select author_id id from Views
where author_id=viewer_id
group by author_id
order by author_id
;