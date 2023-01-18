# Write your MySQL query statement below
select id, @temp:=if(drink is null, @temp, drink) drink from CoffeeShop;