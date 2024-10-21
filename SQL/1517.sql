# Write your MySQL query statement below
select * from Users
where mail REGEXP '^[a-zA-Z][\\w\.\-]*@leetcode\\.com$' 
;

/* Write your PL/SQL query statement below */
select * from Users
where regexp_like(mail, '^[a-zA-Z][-\.\_a-zA-Z0-9]*@leetcode\.com$')
;