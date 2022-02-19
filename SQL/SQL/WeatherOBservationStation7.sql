select
    DISTINCT CITY
FROM
    STATION
WHERE
    CITY REGEXP '[AEIOU]$'
order by
    city;