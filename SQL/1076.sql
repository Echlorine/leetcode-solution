# Write your MySQL query statement below
with temp as (
    select project_id, count(*) num from Project group by project_id
)
select project_id from temp
where num=(select max(num) from temp)
;

# Write your MySQL query statement below
select project_id from Project group by project_id
having count(*) >= all(
    select count(*) from Project group by project_id
)
;