# Write your MySQL query statement below
select * from Users
where mail REGEXP '^[a-zA-Z][\\w\.\-]*@leetcode\\.com$' 
;