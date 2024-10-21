# Write your MySQL query statement below
select max(t.num) as num from
(select num from MyNumbers group by num having count(num) = 1 order by num desc) t
;

/* Write your PL/SQL query statement below */
select max(num) num from (
    select num from MyNumbers
    group by num
    having count(1) = 1
);