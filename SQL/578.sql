# Write your MySQL query statement below
select question_id survey_log
from (
    select question_id, sum(action='answer')/sum(action='show') answer_rate from SurveyLog
    group by question_id
) t
order by answer_rate desc, question_id
limit 0,1
;

# Write your MySQL query statement below
select question_id survey_log from (
    select question_id,
    sum(if(action='answer', 1, 0)) / sum(if(action='show', 1, 0)) as rate
    from SurveyLog
    group by 1
    order by 2 desc, 1
    limit 1
) t
;