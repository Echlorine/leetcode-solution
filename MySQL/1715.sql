# Write your MySQL query statement below
with temp as (
    select box_id, b.apple_count+c.apple_count apple_count, b.orange_count+c.orange_count orange_count
    from Boxes b join Chests c on b.chest_id = c.chest_id
    union all
    select box_id, apple_count, orange_count from Boxes where chest_id is null
)
select sum(apple_count) apple_count, sum(orange_count) orange_count
from temp
;