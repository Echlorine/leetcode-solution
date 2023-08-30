# Write your MySQL query statement below
select c1.seat_id from
Cinema c1 join Cinema c2
on c1.seat_id=c2.seat_id-1 and c1.free=1 and c2.free=1
union
select c1.seat_id from
Cinema c1 join Cinema c2
on c1.seat_id=c2.seat_id+1 and c1.free=1 and c2.free=1
order by seat_id
;

# Write your MySQL query statement below
with t as (
    select seat_id, free, seat_id - row_number() over() tag
    from Cinema
    where free = 1
)
select seat_id from t
where tag in (
    select tag from t
    group by tag
    having count(tag)>1
)
;