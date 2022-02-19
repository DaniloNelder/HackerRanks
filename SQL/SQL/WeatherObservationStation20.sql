SELECT
    cast(x.lat_n as Decimal(10, 4))
from
    Station x,
    Station y
GROUP BY
    x.lat_n
HAVING
    SUM(SIGN(1 - SIGN(y.lat_n - x.lat_n))) = (COUNT(*) + 1) / 2;