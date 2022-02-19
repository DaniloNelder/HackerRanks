SELECT
    CASE
        WHEN Grade >= 8 THEN Name
        ELSE "NULL"
    END,
    Grade,
    Marks
FROM
    Students,
    Grades
WHERE
    Students.Marks >= Min_Mark
    AND Students.Marks <= Max_Mark
ORDER BY
    Grade DESC,
    Name