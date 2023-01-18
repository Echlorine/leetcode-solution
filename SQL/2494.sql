# Write your MySQL query statement below
with t as (
    select *,
    max(end_day) over(partition by hall_id order by hall_id, start_day, end_day rows between unbounded preceding and 1 preceding) max_end
    from HallEvents
)
select hall_id, min(start_day) start_day, max(end_day) end_day from (
    select hall_id, start_day, end_day, max_end,
    @temp:=if(start_day<=max_end, @temp, @temp+1) temp
    from t, (SELECT @temp:=0) init
) tt
group by 1, temp
;