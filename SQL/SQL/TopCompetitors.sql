select
    hacker_id,
    name
from
    (
        select
            Hackers.hacker_id,
            Hackers.name,
            sum(if(Submissions.score = Difficulty.score, 1, 0)) t
        from
            Submissions
            left join Challenges on Challenges.challenge_id = Submissions.challenge_id
            left join Difficulty on Difficulty.difficulty_level = Challenges.difficulty_level
            left join Hackers on Hackers.hacker_id = Submissions.hacker_id
        group by
            1,
            2
    ) A
where
    t > 1
order by
    t desc,
    hacker_id;