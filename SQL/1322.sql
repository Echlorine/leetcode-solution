# Write your MySQL query statement below
with temp as (
    select ad_id, count(if(action='Clicked',1,null)) c_num,count(if(action='Viewed',1,null)) v_num
    from Ads group by ad_id
)
select ad_id, round(if(c_num=0,0,c_num/(c_num+v_num))*100,2) ctr
from temp
order by ctr desc, ad_id
;