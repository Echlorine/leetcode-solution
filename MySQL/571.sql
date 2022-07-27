select round(avg(num),1) as median from
(
    select num,
    sum(frequency) over (order by num rows between unbounded preceding and current row) rank1,
    sum(frequency) over (order by num desc rows between unbounded preceding and current row) rank2,
    sum(frequency) over () cnt
    from Numbers
) t
where t.rank1>=t.cnt/2 and t.rank2>=t.cnt/2
;