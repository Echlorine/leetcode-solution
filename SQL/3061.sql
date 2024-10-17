# Write your MySQL query statement below
with t as (
    select id, height,
    max(height) over(ROWS between unbounded preceding and current row) leftMax,
    max(height) over(ROWS between current row and unbounded following) rightMax
    from Heights
)
select sum(if(leftMax>rightMax, rightMax, leftMax) - height) as total_trapped_water from t
;