# Write your MySQL query statement below
select name from Customer where not referee_id <=> 2;

/* Write your PL/SQL query statement below */
-- select name from Customer where nvl(referee_id, 0) <> 2;
select name from Customer
where referee_id is null or referee_id<>2
;