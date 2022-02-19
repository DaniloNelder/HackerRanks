SELECT
    Case
        when A + B <= C
        or B + C <= A
        or A + C <= B THEN 'Not A Triangle'
        when A = B
        and B = C THEN 'Equilateral'
        when A != B
        and B != C
        and C != A then 'Scalene'
        else 'Isosceles'
    end
from
    Triangles;