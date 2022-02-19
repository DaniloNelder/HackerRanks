set
    @sdate = null;

set
    @nextdate = null;

select
    Sd,
    max(Ed) Ed2
from
    (
        select
            if(
                @nextdate = Start_Date,
                @sdate,
                @sdate := Start_Date
            ) Sd,
            @nextdate := End_Date Ed
        from
            Projects
        order by
            Start_Date
    ) A
group by
    Sd
order by
    datediff(max(Ed), Sd);