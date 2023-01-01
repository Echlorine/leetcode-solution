# Write your MySQL query statement below
select "Low Salary" category, sum(if(income<20000,1,0)) accounts_count from Accounts
union all
select "Average Salary" category, sum(if(income>=20000 and income<=50000,1,0)) accounts_count from Accounts
union all
select "High Salary" category, sum(if(income>50000,1,0)) accounts_count from Accounts
;