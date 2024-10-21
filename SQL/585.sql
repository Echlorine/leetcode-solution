# Write your MySQL query statement below
with a as (
    select PID,
    count(TIV_2015) over (partition by TIV_2015) TIV,
    count(*) over (partition by LAT, LON) ATON from insurance
)
select round(sum(i.TIV_2016),2) TIV_2016 from insurance i join a on i.PID=a.PID
where a.TIV>1 and a.ATON=1
;

/* Write your PL/SQL query statement below */
with t as (
    select pid, tiv_2016, lat, lon from Insurance i1
    where exists (
        select 1 from Insurance i2
        where i1.pid <> i2.pid
        and i1.tiv_2015 = i2.tiv_2015
    )
)
select sum(tiv_2016) tiv_2016 from t
where not exists (
    select 1 from Insurance i
    where t.pid <> i.pid
    and (t.lat = i.lat and t.lon = i.lon)
)
;