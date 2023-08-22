# Write your MySQL query statement below
select 'bull' word, count(1) count from Files
where content REGEXP ' +bull[, \.\ ]'
union all
select 'bear' word, count(1) count from Files
where content REGEXP ' +bear[, \.\ ]'
;