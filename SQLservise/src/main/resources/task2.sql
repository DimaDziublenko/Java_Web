
-- exercise 1 --

ALTER TABLE developers ADD salary float;

-- exercise 2 --

SELECT p.id, p.title, p.industry, p.deadline
FROM projects AS p
INNER JOIN developer_project AS dp ON p.id = dp.project_id
INNER JOIN developers AS d ON dp.developer_id = d.id
GROUP BY p.id, dp.developer_id, dp.project_id, d.id
ORDER BY SUM(d.salary) DESC
LIMIT 1;

-- exercise 3 --

SELECT SUM(d.salary)
FROM developers AS d
INNER JOIN developer_skill AS ds ON d.id = ds.developer_id
INNER JOIN skills AS s ON ds.skill_id = s.id
WHERE s.industry = 'Java';

-- exercise 4 --

ALTER TABLE projects ADD cost float;

-- exercise 5 --

SELECT *
FROM projects AS p
ORDER BY p.cost
LIMIT 1;

-- exercise 6 --

SELECT AVG(d.salary)
FROM developers AS d
INNER JOIN developer_project dp ON d.id = dp.developer_id
INNER JOIN projects p ON dp.project_id = p.id
GROUP BY p.cost
HAVING MIN(p.cost) = p.cost
LIMIT 1;