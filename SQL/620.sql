# Write your MySQL query statement below
select * from cinema
where id%2=1 and description<>'boring'
order by rating desc
;

/* Write your PL/SQL query statement below */
select * from cinema c
where mod(c.id,2) = 1 and c.description <> 'boring'
order by rating desc
;