CREATE TABLE CUSTOMERS(
                          id INT NOT NULL AUTO_INCREMENT,
                          name VARCHAR(255),
                          surname VARCHAR(255),
                          age INT,
                          phone_number INT,
                          PRIMARY KEY(id)
);
INSERT INTO CUSTOMERS (id, name, surname, age, phone_number)
VALUES (1, 'Test', 'Test', 10,772);


CREATE TABLE ORDERS (
                        id INT NOT NULL AUTO_INCREMENT,
                        date DATE,
                        customer_id INT,
                        product_name VARCHAR(255),
                        amount INT,
                        PRIMARY KEY(id),
                        FOREIGN KEY(`customer_id`) REFERENCES CUSTOMERS(`id`)
);
INSERT INTO ORDERS (id, date, customer_id, product_name, amount)
VALUES (1, current_date, 1, 'test_product',7);
INSERT INTO ORDERS (id, date, customer_id, product_name, amount)
VALUES (2, current_date+1, 1, 'test_product2',1);