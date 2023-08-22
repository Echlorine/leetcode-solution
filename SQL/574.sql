# Write your MySQL query statement below
select name from Candidate
where id=(select candidateId from Vote group by candidateId order by count(*) desc limit 0,1)

# Write your MySQL query statement below
select name from Candidate c join (
    select candidateId, count(candidateId) num from Vote
    group by 1
    order by 2 desc
    limit 1
) t
on c.id = t.candidateId
;