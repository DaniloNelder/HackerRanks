select
    Sum(City.Population)
from
    City
    Join Country On City.CountryCode = Country.Code
where
    Country.Continent = 'Asia';