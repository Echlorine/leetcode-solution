# Write your MySQL query statement below
(
    select u.name as results
    from MovieRating r join Users u
    on r.user_id=u.user_id
    group by r.user_id
    order by count(r.movie_id) desc, u.name
    limit 0,1
)
union all
(
    select m.title as results
    from MovieRating r join Movies m
    on r.movie_id=m.movie_id
    where r.created_at between '2020-02-01' and '2020-02-29'
    group by r.movie_id
    order by avg(r.rating) desc, m.title
    limit 0,1
)
;

/* Write your PL/SQL query statement below */
select name results from (
    select u.name, count(movie_id) cnt
    from Users u join MovieRating m
    on u.user_id = m.user_id
    group by u.name
    order by cnt desc, u.name
) where rownum = 1
union all
select title from (
    select m1.movie_id, m1.title, avg(rating) cnt
    from Movies m1 join MovieRating m2
    on m1.movie_id = m2.movie_id
    where m2.created_at between to_date('2020-02-01', 'yyyy-mm-dd') and to_date('2020-02-29', 'yyyy-mm-dd')
    group by m1.movie_id, m1.title
    order by cnt desc, m1.title
) where rownum = 1
;