# Write your MySQL query statement below
with Ttype as (
    select count(*) as num from Transactions
    group by user_id, transaction_date
)

select 0 transactions_count, count(*) as visits_count from Visits
where (user_id, visit_date) not in (select user_id, transaction_date from Transactions)
union all
select rt.n as transactions_count, count(num) as visits_count from (
    with recursive temp as (
        select if((select min(num) from Ttype)>=1,1,null) n
        union all
        select t.n+1 from temp t
        where t.n<(select max(num) from Ttype)
    )
    select * from temp where temp.n is not null
) rt left join Ttype
on rt.n=Ttype.num
group by rt.n
;