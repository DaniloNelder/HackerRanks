SELECT  Hacker_id
       ,name
       ,total_score
FROM
(
	SELECT  A.Hacker_id
	       ,SUM(m_score) total_score
	FROM
	(
		SELECT  hacker_id
		       ,challenge_id
		       ,MAX(score) m_score
		FROM Submissions
		GROUP BY  hacker_id
		         ,challenge_id
	) A
	GROUP BY  hacker_id
) B
LEFT JOIN Hackers using
(hacker_id
)
WHERE total_score > 0
ORDER BY total_score desc, hacker_id