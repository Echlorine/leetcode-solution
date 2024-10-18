# Write your MySQL query statement below
select t2.user_id, round(ifnull(t1.confirm_num/t2.num,0),2) confirmation_rate
from (
    select s.user_id, count(action) confirm_num
    from Signups s left join Confirmations c
    on s.user_id=c.user_id
    where action='confirmed'
    group by s.user_id
) t1 right join (
    select s.user_id, count(action) num
    from Signups s left join Confirmations c
    on s.user_id=c.user_id
    group by s.user_id
) t2
on t1.user_id=t2.user_id
;

/* Write your PL/SQL query statement below */
select s.user_id, round(
    sum(case action when 'confirmed' then 1 else 0 end)
    /
    count(nvl(action, 1)), 2
) confirmation_rate
from Signups s left join Confirmations c
on s.user_id=c.user_id
group by s.user_id
;