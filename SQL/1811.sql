# Write your MySQL query statement below
with t1 as (
    select u.*, c.contest_id
    from Users u join Contests c
    on u.user_id=c.gold_medal or u.user_id=c.silver_medal or u.user_id=c.bronze_medal
    order by u.user_id, contest_id
),
t2 as (
    select u.*, c.contest_id
    from Users u join Contests c
    on u.user_id=c.gold_medal
    order by u.user_id
)
select distinct p1.name, p1.mail from 
t1 p1, t1 p2, t1 p3
where p1.user_id=p2.user_id and p1.user_id=p3.user_id and p1.contest_id=p2.contest_id-1 and p1.contest_id=p3.contest_id-2
union
select name, mail from t2
group by user_id
having count(*)>=3
;