# Write your MySQL query statement below
select id,
if(
    p_id is null,
    'Root',
    if(
        id in(select p_id from tree),
        'Inner',
        'Leaf'
    )
) type
from Tree
order by id
;