SELECT
    MAX(salary * months) AS m,
    COUNT(employee_id) AS c
FROM
    employee
GROUP BY
    (salary * months)
ORDER BY
    (salary * months) DESC
LIMIT
    1;