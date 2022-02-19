select
    distinct(city)
from
    station
where
    city like 'A%'
    or city like 'I%'
    or city like 'E%'
    or city like 'O%'
    or city like 'U%'
order by
    city