# Write your MySQL query statement below
with a as (
    select PID,
    count(TIV_2015) over (partition by TIV_2015) TIV,
    count(*) over (partition by LAT, LON) ATON from insurance
)
select round(sum(i.TIV_2016),2) TIV_2016 from insurance i join a on i.PID=a.PID
where a.TIV>1 and a.ATON=1
;