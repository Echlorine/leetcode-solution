# Write your MySQL query statement below
select username, activity, startDate, endDate from
(
    select *,
    rank() over (partition by username order by endDate desc) as drk,
    rank() over (partition by username order by endDate) as ark
    from UserActivity
) t
where drk=2 or (drk=1 and ark=1)
group by username
;