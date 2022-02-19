SELECT
    DISTINCT CITY
FROM
    STATION
WHERE
    CITY NOT IN (
        SELECT
            CITY
        FROM
            STATION
        WHERE
            CITY RLIKE '^[aeiou].*[aeiou]$'
    )
ORDER BY
    CITY ASC;