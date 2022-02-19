SELECT
    w.id,
    wp.age,
    w.coins_needed,
    w.power
FROM
    wands w
    JOIN wands_property wp ON w.code = wp.code
WHERE
    wp.is_evil = 0
    AND (
        SELECT
            MIN(www.coins_needed)
        FROM
            wands www
            JOIN wands_property wppp ON www.code = wppp.code
        WHERE
            wppp.is_evil = 0
            AND wp.age = wppp.age
            AND www.power = w.power
    ) = w.coins_needed
ORDER by
    w.power DESC,
    wp.age DESC