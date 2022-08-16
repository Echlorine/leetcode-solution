# Write your MySQL query statement below
with temp as (
    select id, visit_date, people, id-row_number() over (order by id) as diff
    from Stadium where people>=100
)
select id, visit_date, people from temp
where diff in (
    select diff from temp group by diff having count(diff)>=3
)
;