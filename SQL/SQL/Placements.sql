select
    x.Name
from
    Students x
    join Friends y on(x.ID = y.ID)
    join Packages p on (x.ID = p.ID)
    join Students z on (y.friend_id = z.id)
    join packages k on (y.friend_id = k.id)
where
    p.salary < k.salary
order by
    k.salary asc;