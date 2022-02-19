select
    Country.Continent,
    floor(avg(City.Population))
from
    City
    join Country on City.CountryCode = Country.Code
GROUP BY
    Country.Continent;