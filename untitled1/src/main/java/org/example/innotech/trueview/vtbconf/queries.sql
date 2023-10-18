/*У клиента может не быть лицевых счетов. По лицевому счёту может не быть транзакций. Необходимо написать SQL запрос, возвращающий имя клиента, описание его лицевого счёта и среднюю сумму транзакции по этому счёту.

Customer
id ( primary key)
name
address

 Account  id ( primary key) 14 acc_number 15 description
I

customer_id ( foreign key-> Customer.id)

    Fin_transaction
id ( primary key)
amount
    transact_date
    account_id ( foreigh key-> Account.id)
 description*/


SELECT c.name, a.description, AVG(f_t.amount)
FROM Customer c
         LEFT JOIN Account a ON c.id = a.customer_id
         LEFT JOIN Fin_Transaction f_t ON a.id = f_t.account_id
GROUP BY c.id;


--как бы ты создал две таблицы customer и phone в SQL?

CREATE TABLE customer (
    id uuid PRIMARY KEY ,
    name TEXT
);

CREATE TABLE phone (
                       id uuid PRIMARY KEY ,
                       name TEXT,
                       customer_id UUID,
                       is_main BOOL NOT NULL,
                       CONSTRAINT c_fk FOREIGN KEY (customer_id) REFERENCES customer(id)
);
--напиши запрос который выводит всех customer у которых нет номера
SELECT c.name
FROM customer c
LEFT JOIN phone p on c.id = p.customer_id
WHERE p.customer_id IS NULL;

--выведи все customer у которых нет основного номера
SELECT c.name
FROM customer c
         LEFT JOIN phone p on c.id = p.customer_id
--WHERE p.is_main IS FALSE;
WHERE p.is_main <> TRUE;
