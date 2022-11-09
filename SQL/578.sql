# Write your MySQL query statement below
select question_id survey_log
from (
    select question_id, sum(action='answer')/sum(action='show') answer_rate from SurveyLog
    group by question_id
) t
order by answer_rate desc, question_id
limit 0,1
;