# Write your MySQL query statement below
with t as (
    select voter, candidate, ifnull(round(1 / count(candidate) over(partition by voter), 2), 0) cnt
    from Votes
),
p as (
    select candidate, sum(cnt) scnt
    from t
    group by candidate
)
select candidate from p
where scnt = (select max(scnt) from p)
order by 1
;