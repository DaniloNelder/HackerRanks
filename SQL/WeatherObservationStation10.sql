select
    distinct CITY
from
    STATION
where
    CITY not in (
        select
            distinct CITY
        from
            STATION
        where
            CITY like '%a'
        union
        select
            distinct CITY
        from
            STATION
        where
            CITY like '%e'
        union
        select
            distinct CITY
        from
            STATION
        where
            CITY like '%i'
        union
        select
            distinct CITY
        from
            STATION
        where
            CITY like '%o'
        union
        select
            distinct CITY
        from
            STATION
        where
            CITY like '%u'
    );