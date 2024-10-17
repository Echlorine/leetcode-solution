# Write your MySQL query statement 
with t as (
    select city, avg(price) p from Listings
    group by 1
)
select city from t
where p > (select avg(price) from Listings)
order by 1
;