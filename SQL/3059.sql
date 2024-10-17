# Write your MySQL query statement below
with t as (
    select SUBSTRING_INDEX(email, '@', -1) email_domain
    from Emails
)
select email_domain, count(*) `count` from t
where email_domain REGEXP '.*com$'
group by 1
order by 1
;