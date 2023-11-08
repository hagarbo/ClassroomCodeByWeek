/* 1- Obtener los identificadores, nombres, país y ciudad de la tabla customers cuyo país sea 
Spain o ciudad sea Lisboa ordenados primero por país y luego por ciudad */

/* 2- Inserta un nuevo registro en la tabla categories con un nombre y una descripción, pero 
sin indicar el CategoryID (se asignará automáticamente) */

INSERT INTO categories (CategoryName,Description) VALUES ("categoria","algo");

/* 3- Averigua el CategoryID asignado al nuevo registro y actualiza el valor de la descripción 
del registro que acabas de insertar: */

UPDATE FROM categories WHERE CategoryID = 9 SET Description = "hola que tal";

/* 4- Elimina el registro que acabas de añadir en categories */

DELETE FROM categories WHERE CategoryID = 9;

/* 5- Obtén los 5 productos de mayor precio: */

SELECT * 
FROM products 
ORDER BY price desc 
LIMIT 5;

/* 6- Obtén la fecha más reciente para la tabla orders */

SELECT MAX(date) 
FROM orders;

/* 7- Obtén el número de registros en la tabla customers */

SELECT COUNT(*)
FROM customers;

/* 8- Obtén el número de distintos clientes que han hecho un pedido. */

SELECT COUNT(DISTINCT CustomerID)
FROM orders;

/* 9- Obtén los empleados que, tienen en la columna Notes, la palabra psychology */

SELECT *
FROM empoyees
WHERE Notes LIKE "%psychology%";

/* 10-Obtén los nombres de los productos y el identificador de la categoría a la que pertenecen de 
aquellos productos cuyo proveedor tienen los identificadors 5 o 6. Utiliza la cláusula IN. 
Ordena el resultado por CategoryID, luego por ProductName */

SELECT ProductName, CategoryID
FROM products 
WHERE SupplierID IN (5,6)
ORDER BY CategoryID,ProductName;

-- 11- Modifica la consulta número 8 para que el resultado se muestre en una columna llamada "Nº clientes con pedidos".

SELECT COUNT(DISTINCT CustomerID) AS "Nº clientes con pedidos"
FROM orders;

-- 12- Obtén el nombre identificador y los nombres de cada producto y su categoría

SELECT products.ProductID, products.ProductName, categories.CategoryName
FROM products JOIN categories
ON products.CategoryID = categories.CategoryID;

/* -- 13- Obtén todos los datos de los clientes que no han hecho ningún pedido. 
-- Utiliza algún tipo de JOIN */

select * 
from customers 
where CustomerID NOT IN 
    (select customers.CustomerID 
    from customers join orders 
    on customers.CustomerID=orders.CustomerID);

SELECT customers.CustomerID,CustomerName,ContactName,Address,City,PostalCode,Country
FROM customers LEFT JOIN orders
ON customers.CustomerID = orders.CustomerID
WHERE orders.CustomerID IS NULL;