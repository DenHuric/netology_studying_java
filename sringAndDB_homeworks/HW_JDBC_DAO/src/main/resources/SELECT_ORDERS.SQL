SELECT o.product_name
FROM ORDERS as o
         JOIN CUSTOMERS as c ON o.customer_id = c.id
WHERE UPPER(c.name) = UPPER(:name);