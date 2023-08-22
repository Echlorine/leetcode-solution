# Write your MySQL query statement below
select artist, count(1) occurrences from Spotify
group by artist
order by 2 desc, 1
;