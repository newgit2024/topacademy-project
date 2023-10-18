/*
Доменная модель компании ООО" Рога и копыта" представлена таблицами
Department и Employee. Необходимо вывести список сотрудников ( id, name),
которые получают максимальную зп в своем отделе.
  Department
  id name
  Employee
  id
  department_id
  name salary
  */

SELECT e.id, e.name
FROM Employee e
INNER JOIN Department d ON e.department_id = d.id
WHERE e.salary = (
    SELECT MAX(salary)
    FROM Employee
    WHERE department_id = e.department_id
);
--
WITH RankedEmployees AS (
    SELECT
        e.id,
        e.name,
        e.department_id,
        e.salary,
        RANK() OVER (PARTITION BY e.department_id ORDER BY e.salary DESC) AS salary_rank
    FROM Employee e
)
SELECT id, name
FROM RankedEmployees
WHERE salary_rank = 1;


