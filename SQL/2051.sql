# Write your MySQL query statement below
with temp as (
    select m.*, count(p.charged_amount)/count(*)*100 ratio, v.visit_date
    from (Members m left join Visits v on m.member_id=v.member_id) left join Purchases p on v.visit_id=p.visit_id
    group by m.member_id
)
select t.member_id, t.name,
case
when ratio>=80 then "Diamond"
when ratio>=50 then "Gold"
when ratio<50 and visit_date is not null then "Silver"
else "Bronze"
end category
from temp t
;