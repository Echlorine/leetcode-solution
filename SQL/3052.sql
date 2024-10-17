# Write your MySQL query statement below
with t as (
    select item_type, count(1) cnt, sum(square_footage) as square, FLOOR(500000 / sum(square_footage)) * sum(square_footage) as sum_square
    from Inventory
    where item_type='prime_eligible'
),
t2 as (
    select count(1) not_cnt, sum(square_footage) as not_square from Inventory
    where item_type='not_prime'
)
select 'prime_eligible' as item_type, sum_square/square * cnt as item_count
from t join t2
union
select 'not_prime' as item_type, FLOOR((500000 - sum_square)/not_square) * not_cnt as item_count
from t join t2
where not_square is not null
;