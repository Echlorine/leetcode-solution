# Write your MySQL query statement below
with temp as (
    select product_id, average_daily_sales,
    greatest('2018-01-01',period_start) as start, least(period_end,'2018-12-31') as end from Sales
    union all
    select product_id, average_daily_sales,
    greatest('2019-01-01',period_start) as start, least(period_end,'2019-12-31') as end from Sales
    union all
    select product_id, average_daily_sales,
    greatest('2020-01-01',period_start) as start, least(period_end,'2020-12-31') as end from Sales
)
select temp.product_id, p.product_name, date_format(start, "%Y") as report_year,
average_daily_sales*(datediff(end, start) +1) as total_amount
from temp join Product p
on temp.product_id=p.product_id
where datediff(end, start)>-1
order by temp.product_id,report_year
;

# Write your MySQL query statement below
with recursive temp as (
    select
        product_id, average_daily_sales,
        period_start as start,
        if (str_to_date(concat(year(period_start),'-12-31'), '%Y-%m-%d') < period_end,
            str_to_date(concat(year(period_start),'-12-31'), '%Y-%m-%d'), period_end) as end
    from Sales
    UNION ALL
        select
            t.product_id, t.average_daily_sales,
            DATE_ADD(t.end, INTERVAL 1 DAY) as start,
            if (DATE_ADD(t.end, INTERVAL 1 YEAR) < period_end,
                DATE_ADD(t.end, INTERVAL 1 YEAR), period_end) as end
        from temp t join Sales s
        on t.product_id=s.product_id
        where end < s.period_end
)
select temp.product_id, p.product_name, date_format(start, "%Y") as report_year,
average_daily_sales*(datediff(end, start) +1) as total_amount
from temp join Product p
on temp.product_id=p.product_id
where year(start) between '2018' and '2020'
order by temp.product_id,report_year
;