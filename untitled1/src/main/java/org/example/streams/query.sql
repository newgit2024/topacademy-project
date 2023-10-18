create table if not exists employee ( id bigint not null primary key, name text not null,) ;
salary bigint not null
insert into employee (' id',' name',' salary') values
( 1,' empl", 500), ( 2, emp2, 90), ( 3, emp3, 500),-- ( 4, emp4', 90), ( 5," emp5, 100) ;


--
SELECT DISTINCT salary FROM employee ORDER BY salary DESC SKIP 1 LIMIT 1;

SELECT salary
FROM employee
ORDER BY salary DESC
LIMIT 1 OFFSET 1;


SELECT DISTINCT salary
FROM employee
ORDER BY salary DESC
LIMIT 1 OFFSET 1;



SELECT MAX(salary) AS second_highest_salary
FROM employee
WHERE salary < (SELECT MAX(salary) FROM employee);


SELECT MAX(salary) AS second_highest_salary
FROM employee
GROUP BY salary
HAVING salary < MAX(salary)
ORDER BY second_highest_salary DESC
LIMIT 1;





CREATE TABLE IF NOT EXISTS "employee" (
	"id" INTEGER NOT NULL DEFAULT 'nextval(''employee_id_seq''::regclass)',
	"chef_id" INTEGER NULL DEFAULT NULL,
	"name" VARCHAR(50) NULL DEFAULT 'NULL::character varying',
	"salary" INTEGER NULL DEFAULT '0',
	"department_id" INTEGER NOT NULL,
	CONSTRAINT "FKemployee_department" FOREIGN KEY ("department_id") REFERENCES "department" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION
);

INSERT INTO "employee" ("id", "chef_id", "name", "salary", "department_id") VALUES
	(2, NULL, 'emp1', 300, 1),
	(4, 2, 'emp2', 150, 1),
	(8, NULL, 'emp4', 220, 3),
	(18, 6, 'emp9', 135, 1),
	(16, 8, 'emp8', 180, 3),
	(12, 14, 'emp6', 200, 6),
	(10, 14, 'emp5', 140, 6),
	(14, NULL, 'emp7', 190, 6),
	(6, 4, 'emp3', 190, 1);



SELECT e.id, e.name, e.salary
FROM employee e
JOIN employee chief ON e.chef_id = chief.id
WHERE e.salary > chief.salary;


SELECT e.id, e.name, e.salary
FROM employee e
WHERE e.salary > (
    SELECT salary
    FROM employee
    WHERE id = e.chef_id
) AND e.id <> e.chef_id;


To retrieve non-unique (duplicate) email values of customers from the customers table, you can use a SQL query with the `GROUP BY` and `HAVING` clauses. The `GROUP BY` clause groups the data by the email column, and the `HAVING` clause filters the results to include only those email values that appear more than once. Here's the SQL query to achieve this:

```sql
SELECT email
FROM customers
GROUP BY email
HAVING COUNT(email) > 1;
```

Explanation:
1. `SELECT email`: This part of the query selects the email column from the customers table.
2. `GROUP BY email`: The data is grouped by the email column. This will consolidate rows with the same email value into a single row.
3. `HAVING COUNT(email) > 1`: The `HAVING` clause filters the grouped data and includes only those groups (emails) that have a count greater than one, meaning they are non-unique.

When you execute this SQL query, it will return the email values that are not unique in the customers table. These are the email values that appear in more than one row.
