CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct salary as getNthHighestSalary from Employee
      order by salary desc
      limit 1 offset M
  );
END


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select distinct salary from (
          select salary, dense_rank() over (order by salary desc) as `rank` from Employee
      ) t
      where `rank`=N
  );
END