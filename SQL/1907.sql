# Write your MySQL query statement below
select "Low Salary" category, sum(if(income<20000,1,0)) accounts_count from Accounts
union all
select "Average Salary" category, sum(if(income>=20000 and income<=50000,1,0)) accounts_count from Accounts
union all
select "High Salary" category, sum(if(income>50000,1,0)) accounts_count from Accounts
;

/* Write your PL/SQL query statement below */
with t as (
    select account_id,
    case
        when income<20000 then 'Low Salary'
        when income>50000 then 'High Salary'
        else 'Average Salary'
    end category
    from Accounts
)
select p.category, count(t.account_id) accounts_count
from (
    select 'Low Salary' as category from dual
    union
    select 'Average Salary' as category from dual
    union 
    select 'High Salary' as category from dual
) p left join t
on p.category=t.category
group by p.category
;