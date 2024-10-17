# Write your MySQL query statement below
with t as (
    select *, dense_rank() over(partition by country order by pts desc, winery) rk from (
        select id, country, sum(points) pts, winery from Wineries group by 2,4
    ) temp
)
select
    country,
    group_concat(if(rk=1, concat(winery, ' (', pts, ')'), null)) top_winery,
    ifnull(group_concat(if(rk=2, concat(winery, ' (', pts, ')'), null)), 'No second winery') second_winery,
    ifnull(group_concat(if(rk=3, concat(winery, ' (', pts, ')'), null)), 'No third winery') third_winery
from t
group by 1
;