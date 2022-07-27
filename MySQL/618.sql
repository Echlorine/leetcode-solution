# Write your MySQL query statement below
with t1 as (
    select name, continent,
    row_number() over (order by name) as rk
    from Student
    where continent='America'
),
t2 as (
    select name, continent,
    row_number() over (order by name) as rk
    from Student
    where continent='Asia'
),
t3 as (
    select name, continent,
    row_number() over (order by name) as rk
    from Student
    where continent='Europe'
)
select t1.name America, t2.name Asia, t3.name Europe from
(t1 left join t2 on t1.rk=t2.rk) left join t3 on t1.rk=t3.rk