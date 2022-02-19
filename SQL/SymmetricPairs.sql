select
    X,
    Y
from
    (
        select
            X,
            Y,
            1 d
        from
            Functions
        where
            (X, Y) in (
                select
                    Y,
                    X
                from
                    Functions
            )
            and X != Y
        union
        all
        select
            X,
            Y,
            count(*) d
        from
            Functions
        group by
            X,
            Y
        having
            d >= 2
    ) A
where
    X <= Y
order by
    X,
    Y