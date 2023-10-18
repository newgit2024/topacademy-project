--Вывести список отделов и количество сотрудников в каждом отделе из таблицы "Departments" и "Employees".
SELECT d.name, count(e.id)
FROM departments d LEFT JOIN employees e ON e.department_id = d.id
GROUP BY d.name;

--Вывести список сотрудников, у которых зарплата выше средней зарплаты по всем сотрудникам.
SELECT * FROM employees e WHERE e.salary > (SELECT AVG(salary) FROM e);

--Вывести список отделов, в которых есть хотя бы один сотрудник с зарплатой выше 50000.
SELECT DISTINCT d.name
FROM departments d INNER JOIN employees e ON e.department_id = d.id
WHERE e.salary > 50000;

--Вывести список сотрудников, которые не привязаны к какому-либо отделу (department_id = NULL).
SELECT * FROM employees e WHERE e.department_id IS NULL;

--Вывести список отделов и среднюю зарплату сотрудников в каждом отделе из таблицы "Departments" и "Employees".
SELECT d.name, AVG(e.salary)
FROM departments d
LEFT JOIN employees e ON e.department_id = d.id
GROUP BY d.name;


--Вывести список сотрудников, чьи имена начинаются на букву "A".
SELECT * FROM employees e WHERE e.name LIKE 'A%';

--Вывести список отделов, в которых зарплата всех сотрудников превышает 100000.
SELECT d.name
FROM departments d INNER JOIN employees e ON e.department_id = d.id
WHERE (SELECT SUM(salary) FROM e) > 100000;

SELECT department_id FROM Employees
GROUP BY department_id
HAVING SUM(salary) > 100000;

--Вывести список сотрудников, чьи имена заканчиваются на букву "я".
SELECT * FROM employees e
WHERE e.name LIKE '%я';

--Вывести список сотрудников, у которых нет указанного номера телефона (phone_number = NULL).
SELECT * FROM employees e
WHERE e.phone IS NULL;

--Вывести список отделов и количество сотрудников в каждом отделе, у которых возраст больше 25 лет.
SELECT d.name, COUNT(e.id)
FROM departments d LEFT JOIN employees e ON e.department_id = d.id
GROUP BY d.id
HAVING e.age > 25;


SELECT d.department_name, COUNT(e.employee_id) AS employee_count
FROM Departments d
LEFT JOIN Employees e ON d.department_id = e.department_id
WHERE e.age > 25
GROUP BY d.department_name;

--Вывести список сотрудников, чьи зарплаты лежат в диапазоне от 40000 до 60000.
SELECT * FROM employees e
WHERE e.salary BETWEEN 40000 AND 60000;


--Вывести список отделов и суммарную зарплату сотрудников в каждом отделе.
SELECT d.name, SUM(salary)
FROM departments d LEFT JOIN employees e ON e.department_id = d.id
GROUP BY d.id;

SELECT d.department_name, SUM(e.salary) AS total_salary
FROM Departments d
LEFT JOIN Employees e ON d.department_id = e.department_id
GROUP BY d.department_name;


--Вывести список отделов, в которых нет ни одного сотрудника.
SELECT d.department_name
FROM Departments d
EXCEPT Employees e ON d.department_id = e.department_id
GROUP BY d.department_name;


SELECT d.department_name FROM Departments d
LEFT JOIN Employees e ON d.department_id = e.department_id
WHERE e.employee_id IS NULL;

--Вывести список сотрудников, у которых возраст равен 30 или 35.
SELECT * FROM employees e
WHERE e.age IN (30, 35);

--Вывести список отделов и средний возраст сотрудников в каждом отделе.
SELECT d.department_name, AVG(e.age)
FROM Departments d
LEFT JOIN Employees e ON d.department_id = e.department_id
GROUP BY d.name;

--Вывести список сотрудников, чьи имена состоят из двух слов.
SELECT * FROM employees e
WHERE e.name LIKE '% %';


--Вывести список отделов, в которых сотрудники имеют хотя бы одинаковую зарплату.
SELECT NOT DISTINCT d.department_name
FROM Departments d
LEFT JOIN Employees e ON d.department_id = e.department_id
GROUP BY e.salary;

SELECT d.department_name FROM Departments d
INNER JOIN Employees e ON d.department_id = e.department_id
GROUP BY d.department_name
HAVING COUNT(DISTINCT e.salary) = 1;
