# Write your MySQL query statement below
with a as (
    select * from
    (select distinct spend_date from Spending) t1
    join
    (
        select 'mobile' as platform, 1 as m_num, 0 as d_num
        union all
        select 'desktop' as platform, 0 as m_num, 1 as d_num
        union all
        select 'both' as platform, 1 as m_num, 1 as d_num
    ) t2
),
b as (
    select user_id, spend_date,
    sum(amount) amount,
    if(sum(platform='mobile')=0,0,1) as m_num,
    if(sum(platform='desktop')=0,0,1) as d_num
    from Spending
    group by user_id, spend_date
)
select a.spend_date, a.platform, ifnull(t.amount,0) total_amount, ifnull(t.users,0) total_users from
a left join (
    select spend_date, m_num, d_num, sum(amount) amount, count(*) users from b
    group by spend_date, m_num, d_num
) t
on a.spend_date=t.spend_date and a.m_num=t.m_num and a.d_num=t.d_num
;