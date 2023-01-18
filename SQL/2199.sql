# Write your MySQL query statement below
with t as (
    select p.post_id, k.topic_id
    from Posts p left join Keywords k
    on INSTR(concat(' ',p.content,' '), concat(' ',k.word,' '))<>0
)
select post_id, group_concat(distinct topic_id order by topic_id) topic from t
where t.topic_id is not null
group by 1
union all
select post_id, "Ambiguous!" topic from t where t.topic_id is null
;