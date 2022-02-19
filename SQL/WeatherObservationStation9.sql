select
    distinct city
from
    station
where
    city regexp '^[^AEIOU]'
order by
    city;