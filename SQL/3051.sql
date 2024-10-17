# Write your MySQL query statement below
select candidate_id from Candidates
where skill='Python' or skill='Tableau' or skill='PostgreSQL'
group by 1
having count(candidate_id) = 3
order by 1
;