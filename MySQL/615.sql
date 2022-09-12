# Write your MySQL query statement below
with a as (
    select date_format(pay_date, "%Y-%m") as pay_month, avg(amount) avg_amount from salary group by date_format(pay_date, "%Y-%m")
),
b as (
    select date_format(pay_date, "%Y-%m") as pay_month, department_id, avg(amount) avg_amount
    from salary s join employee e on s.employee_id=e.employee_id
    group by date_format(pay_date, "%Y-%m"), e.department_id
)
select b.pay_month, b.department_id,
case 
when b.avg_amount>a.avg_amount then 'higher'
when b.avg_amount=a.avg_amount then 'same'
when b.avg_amount<a.avg_amount then 'lower'
end comparison
from b join a on b.pay_month=a.pay_month
;