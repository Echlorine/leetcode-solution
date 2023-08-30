# Write your MySQL query statement below
select min(b.x-a.x) shortest from point a join point b on b.x>a.x
;

# Write your MySQL query statement below
with t as (
    select x, rank() over(order by x) rk from Point
)
select min(t2.x - t1.x) shortest from
t t1 join t t2
on t1.rk = t2.rk - 1
;