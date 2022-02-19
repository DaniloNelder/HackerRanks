select
    con.contest_id,
    con.hacker_id,
    con.name,
    sum(total_submissions) total_submissions,
    sum(total_accepted_submissions) total_accepted_submissions,
    sum(total_views) total_views,
    sum(total_unique_views) total_unique_views
from
    Contests con
    left join Colleges col on col.contest_id = con.contest_id
    left join (
        select
            c.college_id,
            sum(total_submissions) total_submissions,
            sum(total_accepted_submissions) total_accepted_submissions,
            sum(total_views) total_views,
            sum(total_unique_views) total_unique_views
        from
            Challenges c
            left join (
                select
                    challenge_id,
                    sum(total_submissions) total_submissions,
                    sum(total_accepted_submissions) total_accepted_submissions
                from
                    Submission_Stats
                group by
                    challenge_id
            ) t1 on t1.challenge_id = c.challenge_id
            left join (
                select
                    challenge_id,
                    sum(total_views) total_views,
                    sum(total_unique_views) total_unique_views
                from
                    View_Stats
                group by
                    challenge_id
            ) t2 on t2.challenge_id = c.challenge_id
        group by
            c.college_id
    ) cha on cha.college_id = col.college_id
where
    ifnull(total_submissions, 0) + ifnull(total_accepted_submissions, 0) + ifnull(total_views, 0) + ifnull(total_unique_views, 0) > 0
group by
    con.contest_id,
    con.hacker_id,
    con.name
order by
    con.contest_id;