/*Дано:
Склад ( таблица warehouse), товары ( таблица item) и
  связанная таблица товары на складе ( таблица warehouse_item).
Необходимо найти на каждом складе категорию товара,
  у которой общая стоимость товаров на складе находится на 3 месте.
Места распределяются по общей стоимости товаров одной категории на одном складе,
  где 1 место- это максимальная сумма товаров одной категории в рамках одного склада.
Вывести название склада, название категории и общую стоимость товаров данной категории на складе.
Например из списка
1. склад 1 категория 1 5000
2. склад 1 категория 2 5000
5. склад 1 категория 3 3008
4. склад 1 категория 4 3008
5. склад 1 категория 5 1008
6. склад 1 категория 6 1088
7. склад 2 категория 1 5008
3. склад 2 категория 2 4668
9. склад 2 категория 3 3000
10. склад 2 категория 4 2000
11. склад 2 категория 5 1000
12. склад 2 категория 6 1000*/


CREATE TABLE warehouse
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE category
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE item
(
    id          SERIAL PRIMARY KEY,
    name        TEXT,
    price       DOUBLE PRECISION,
    category_id INT,
    CONSTRAINT category_id_fk FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE warehouse_item
(
    warehouse_id INT,
    item_id      INT
);

/*Необходимо найти на каждом складе категорию товара,
  у которой общая стоимость товаров на складе находится на 3 месте.
Места распределяются по общей стоимости товаров одной категории на одном складе,
  где 1 место- это максимальная сумма товаров одной категории в рамках одного склада.
Вывести название склада, название категории и общую стоимость товаров данной категории на складе.*/

SELECT w.name, c.name, sum(i.price) tp
FROM warehouse w
         JOIN warehouse_item wi on w.id = wi.warehouse_id
         JOIN item i on wi.item_id = i.id
         JOIN category c on i.category_id = c.id
group by w.name AND c.name
ORDER BY c.name AND w.name AND sum(i.price) DESC;


SELECT w.name, c.name, SUM(i.price) AS total_price
FROM warehouse w
         JOIN warehouse_item wi on w.id = wi.warehouse_id
         JOIN item i on wi.item_id = i.id
         JOIN category c on i.category_id = c.id
GROUP BY w.name, c.name
HAVING COUNT(DISTINCT i.price) >= 3
ORDER BY w.name, c.name, total_price DESC;


--1.
SELECT w.name, c.name, SUM(i.price) AS total_price
FROM warehouse w
         INNER JOIN warehouse_item wi ON w.id = wi.warehouse_id
         INNER JOIN item i ON wi.item_id = i.id
         INNER JOIN category c ON i.category_id = c.id
GROUP BY w.name, c.name
HAVING COUNT(DISTINCT i.price) >= 3
ORDER BY w.name, c.name, total_price DESC;

--2.
SELECT w.name, c.name, SUM(i.price) AS total_price
FROM warehouse w
         JOIN warehouse_item wi ON w.id = wi.warehouse_id
         JOIN item i ON wi.item_id = i.id
         JOIN category c ON i.category_id = c.id
WHERE i.price IS NOT NULL
GROUP BY w.name, c.name
HAVING COUNT(DISTINCT i.price) >= 3
ORDER BY w.name, c.name, total_price DESC;

--3.
SELECT w.name, c.name, SUM(i.price) AS total_price
FROM warehouse w,
     warehouse_item wi,
     item i,
     category c
WHERE w.id = wi.warehouse_id
  AND wi.item_id = i.id
  AND i.category_id = c.id
GROUP BY w.name, c.name
HAVING COUNT(DISTINCT i.price) >= 3
ORDER BY w.name, c.name, total_price DESC;

--Создание таблицы warehouse:

CREATE TABLE warehouse
(
    id   INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
--Создание таблицы item:
CREATE TABLE item
(
    id          INT PRIMARY KEY,
    name        VARCHAR(255)   NOT NULL,
    category_id INT            NOT NULL,
    price       DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (id)
);
--Создание таблицы warehouse_item:

CREATE TABLE warehouse_item
(
    id           INT PRIMARY KEY,
    warehouse_id INT NOT NULL,
    item_id      INT NOT NULL,
    FOREIGN KEY (warehouse_id) REFERENCES warehouse (id),
    FOREIGN KEY (item_id) REFERENCES item (id)
);

CREATE TABLE category
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

/*Необходимо найти на каждом складе категорию товара,
  у которой общая стоимость товаров на складе находится на 3 месте.
Места распределяются по общей стоимости товаров одной категории на одном складе,
  где 1 место- это максимальная сумма товаров одной категории в рамках одного склада.
Вывести название склада, название категории и общую стоимость товаров данной категории на складе.*/

/*SELECT w.name,
       c.name,
       sum(i.price) tp
FROM warehouse w
         JOIN (SELECT w.name,
                      c.name,
                      SUM(i.price) tpi,
                      rank() OVER (PARTITION BY i.category_id
                          ORDER BY tpi DESC)
               FROM warehouse w
                        INNER JOIN warehouse_item wi ON w.id = wi.warehouse_id
                        INNER JOIN item i ON wi.item_id = i.id
                        INNER JOIN category c ON i.category_id = c.id
               GROUP BY w.name, c.name
               HAVING tpi >= 3
               ORDER BY tpi)
         INNER JOIN warehouse_item wi ON w.id = wi.warehouse_id
         INNER JOIN item i ON wi.item_id = i.id
         INNER JOIN category c ON i.category_id = c.id
GROUP BY w.name, c.name;*/


SELECT w.name,
       rc.category_name,
       rc.total_price
FROM warehouse w
         JOIN (SELECT w.id                                                             warehouse_id,
                      c.name                                                           category_name,
                      SUM(i.price)                                                     total_price,
                      ROW_NUMBER() OVER (PARTITION BY w.id ORDER BY SUM(i.price) DESC) category_rank
               FROM warehouse w
                        JOIN warehouse_item wi ON w.id = wi.warehouse_id
                        JOIN item i ON wi.item_id = i.id
                        JOIN category c ON i.category_id = c.id
               GROUP BY w.id, c.name) rc ON w.id = rc.warehouse_id AND rc.category_rank = 3
ORDER BY w.name, rc.category_name;


/*Необходимо найти на каждом складе категорию товара,
  у которой общая стоимость товаров на складе находится на 3 месте.
Места распределяются по общей стоимости товаров одной категории на одном складе,
  где 1 место- это максимальная сумма товаров одной категории в рамках одного склада.
Вывести название склада, название категории и общую стоимость товаров данной категории на складе.*/
SELECT w.name, rc.category_name, rc.total_price
FROM warehouse w
         JOIN (SELECT w.id warehouse_id, c.name category_name, SUM(i.price) total_price,
                      ROW_NUMBER() over (PARTITION BY w.id ORDER BY SUM(i.price) DESC) r_n
               FROM warehouse
                        join warehouse_item wi on w.id = wi.warehouse_id
                        JOIN item i on wi.item_id = i.id
                        JOIN category c on i.category_id = c.id
               GROUP BY w.id, c.name
               ) rc on w.id = rc.warehouse_id
AND rc.r_n = 3
ORDER BY w.id, rc.category_name;



SELECT w.name         AS warehouse_name,
       rc.category_name,
       rc.total_price AS category_total_price
FROM warehouse w
         JOIN (SELECT w.id                                                             AS warehouse_id,
                      c.name                                                           AS category_name,
                      SUM(i.price)                                                     AS total_price,
                      DENSE_RANK() OVER (PARTITION BY w.id ORDER BY SUM(i.price) DESC) AS category_rank
               FROM warehouse w
                        JOIN warehouse_item wi ON w.id = wi.warehouse_id
                        JOIN item i ON wi.item_id = i.id
                        JOIN category c ON i.category_id = c.id
               GROUP BY w.id, c.name) rc ON w.id = rc.warehouse_id AND rc.category_rank = 3
ORDER BY w.name, rc.category_name;


SELECT w.name       AS warehouse_name,
       c.name       AS category_name,
       SUM(i.price) AS category_total_price
FROM warehouse w
         JOIN warehouse_item wi ON w.id = wi.warehouse_id
         JOIN item i ON wi.item_id = i.id
         JOIN category c ON i.category_id = c.id
GROUP BY w.name, c.name
HAVING COUNT(DISTINCT i.price) >= 3
ORDER BY w.name, category_total_price DESC;


SELECT w.name, c.name, sum(i.price) tp
FROM warehouse w
         JOIN warehouse_item wi on w.id = wi.warehouse_id
         JOIN item i on wi.item_id = i.id
         JOIN category c on i.category_id = c.id
group by w.name AND c.name
ORDER BY c.name AND w.name AND sum(i.price) DESC;


/*Необходимо найти на каждом складе категорию товара,
  у которой общая стоимость товаров на складе находится на 3 месте.
Места распределяются по общей стоимости товаров одной категории на одном складе,
  где 1 место- это максимальная сумма товаров одной категории в рамках одного склада.
Вывести название склада, название категории и общую стоимость товаров данной категории на складе.*/


CREATE TABLE warehouse
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE category
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE item
(
    id          SERIAL PRIMARY KEY,
    name        TEXT,
    price       DOUBLE PRECISION,
    category_id INT,
    CONSTRAINT category_id_fk FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE warehouse_item
(
    id           SERIAL PRIMARY KEY,
    warehouse_id INT,
    item_id      INT,
    CONSTRAINT w_id_fk FOREIGN KEY (warehouse_id) REFERENCES warehouse (id),
    CONSTRAINT i_id_fk FOREIGN KEY (item_id) REFERENCES item (id)
);


/*Необходимо найти на каждом складе категорию товара,
  у которой общая стоимость товаров на складе находится на 3 месте.
Места распределяются по общей стоимости товаров одной категории на одном складе,
  где 1 место- это максимальная сумма товаров одной категории в рамках одного склада.
Вывести название склада, название категории и общую стоимость товаров данной категории на складе.*/


SELECT w.name, c.name, SUM(i.price) t_p
FROM warehouse w,
     item i,
     warehouse_item wi,
     category c
GROUP BY w.id, c.id
HAVING COUNT(DISTINCT i.price) >= 3
ORDER BY t_p DESC;


SELECT w.name       AS warehouse_name,
       c.name       AS category_name,
       SUM(i.price) AS category_total_price
FROM warehouse w
         JOIN warehouse_item wi ON w.id = wi.warehouse_id
         JOIN item i ON wi.item_id = i.id
         JOIN category c ON i.category_id = c.id
GROUP BY w.name, c.name
HAVING COUNT(DISTINCT i.price) >= 3
ORDER BY w.name, category_total_price DESC;


SELECT w.name, c.name, SUM(i.price) AS t_p
FROM warehouse w
         JOIN warehouse_item wi ON w.id = wi.warehouse_id
         JOIN item i ON i.id = wi.item_id
         JOIN category c ON i.category_id = c.id
GROUP BY w.id, c.id
HAVING COUNT(DISTINCT i.price) >= 3
ORDER BY t_p DESC;









