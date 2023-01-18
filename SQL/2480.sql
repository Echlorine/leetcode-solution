# Write your MySQL query statement below
with Metal as (
    select symbol from Elements
    where type = 'Metal'
),
Nonmetal as (
    select symbol from Elements
    where type = 'Nonmetal'
)
select m.symbol metal, n.symbol nonmetal
from Metal m cross join Nonmetal n
;