USE Jardineria;
#-------------------------------------------------------------------------------------------
#	1. Crea una vista de los empleados con código, nombre completo, email, puesto de trabajo, extensión y oficina
#-------------------------------------------------------------------------------------------
DROP VIEW if EXISTS vista_empleados;
CREATE VIEW vista_empleados AS
	SELECT codigo_empleado, CONCAT(nombre,' ', apellido1,' ',apellido2) AS 'Nombre Completo', email, puesto,extension,codigo_oficina
	FROM empleado;
#-------------------------------------------------------------------------------------------
#	2. Crea una vista de Clientes y estado de los pedidos, mostrando nombre de la empresa cliente, teléfono, código del pedido y estado en el que se halla
#-------------------------------------------------------------------------------------------
DROP VIEW if EXISTS Vista_Pedidos_Cliente;
CREATE VIEW Vista_Pedidos_Cliente AS
	SELECT nombre_cliente AS Empresa, telefono AS Telefono, codigo_pedido AS 'Codigo de pedido', estado AS 'Estado'
	FROM cliente INNER JOIN pedido ON cliente.codigo_cliente = pedido.codigo_pedido; 
#-------------------------------------------------------------------------------------------
#	3. Crea una vista de los productos que se hallen en stock, mostrando código y nombre del producto y su cantidad en stock
#-------------------------------------------------------------------------------------------
DROP VIEW if EXISTS Productos_con_Stock;
CREATE VIEW Productos_con_Stock AS
	SELECT codigo_producto, nombre
	FROM producto 
	WHERE cantidad_en_stock > 0;
#-------------------------------------------------------------------------------------------
#	4. Crea una vista sobre los pagos realizados, mostrando el nombre de la empresa cliente, la transacción efectuada, el tipo, fecha y total de pago abonada
#-------------------------------------------------------------------------------------------
DROP VIEW if EXISTS Pagos_Realizados;
CREATE VIEW Pagos_Realizados AS
	SELECT nombre_cliente AS Empresa, id_transaccion AS Transaccion, forma_pago AS Tipo, fecha_pago AS fecha, total AS Total
	FROM pago INNER JOIN cliente ON pago.codigo_cliente = cliente.codigo_cliente;
#-------------------------------------------------------------------------------------------
#	5. Crea una vista de los pedidos pendientes de atender, mostrando código de pedido, fecha de realización del pedido y fecha esperada de recepción
#-------------------------------------------------------------------------------------------
DROP VIEW if EXISTS Pedidos_Pendientes;
CREATE VIEW Pedidos_Pendientes AS
	SELECT codigo_pedido, fecha_pedido AS Realizado, fecha_esperada AS Entrega_Esperada
	FROM pedido
	WHERE estado = 'Pendiente';
#-------------------------------------------------------------------------------------------
#	6. Crea una vista de ventas en función de la gama del producto, mostrando la gama, número de ventas efectuadas y total del dinero obtenido en cada gama
#-------------------------------------------------------------------------------------------
DROP VIEW if EXISTS Ventas_Por_Gama;
CREATE VIEW Ventas_Por_Gama AS
	SELECT g.gama, SUM(d.cantidad * d.precio_unidad) AS Dineros
	FROM gama_producto g INNER JOIN producto p ON g.gama = p.gama
								INNER JOIN detalle_pedido d ON p.codigo_producto = d.codigo_producto
	GROUP BY g.gama
	ORDER BY Dineros DESC;
#-------------------------------------------------------------------------------------------
#	7. Crea una vista mostrando el nombre del país y el número total de clientes que tiene cada uno
#-------------------------------------------------------------------------------------------
DROP VIEW if EXISTS Clientes_Por_Pais;
CREATE VIEW Clientes_Por_Pais AS
SELECT COUNT(codigo_cliente) AS 'Numero de Clientes', pais
FROM cliente 
GROUP BY pais;
#-------------------------------------------------------------------------------------------
#	8. Crea una vista que muestre el código y nombre del producto que se hallen agotados
#-------------------------------------------------------------------------------------------
SELECT codigo_producto, nombre
FROM producto 
WHERE cantidad_en_stock = 0;
#-------------------------------------------------------------------------------------------
#	9. Crea una vista sobre el detalle de pedido asociado a los productos, mostrando, código de pedido, nombre producto, cantidad, precio por unidad y precio final
#-------------------------------------------------------------------------------------------
SELECT d.codigo_pedido, p.nombre, d.cantidad, d.precio_unidad
FROM producto p INNER JOIN detalle_pedido d ON p.codigo_producto=d.codigo_producto; 
#-------------------------------------------------------------------------------------------
#	10. Crea una vista entre empleados y oficinas, mostrando código y nombre completo del empleado, puesto de trabajo que realiza, y ciudad y país en donde trabaja
#-------------------------------------------------------------------------------------------

#-------------------------------------------------------------------------------------------
#  11. Crea una vista con los clientes que han excedido su límite de crédito, mostrando en cuánto han excedido ese límite
#-------------------------------------------------------------------------------------------

#-------------------------------------------------------------------------------------------
#  12. Crea una vista del número de ventas efectuadas por ciudad
#-------------------------------------------------------------------------------------------

#-------------------------------------------------------------------------------------------
#  13. Crea una vista que muestre el número de productos que hay por cada Proveedor
#-------------------------------------------------------------------------------------------

#-------------------------------------------------------------------------------------------
#  14. Crea una vista que muestre el nombre de la empresa cliente y el número de órdenes de compra asociadas
#-------------------------------------------------------------------------------------------

#-------------------------------------------------------------------------------------------
#  15. Crea una vista que muestre el número de pedidos por estado en el que se hallen
#-------------------------------------------------------------------------------------------

#-------------------------------------------------------------------------------------------
#  16. Crea una vista que asocie empleados, con identificador y nombre completo, y el número de clientes asignados
#-------------------------------------------------------------------------------------------

#-------------------------------------------------------------------------------------------
#  17. Crea una vista de los productos vendidos, mostrando código de producto, nombre y unidades vendidas
#-------------------------------------------------------------------------------------------

#-------------------------------------------------------------------------------------------
#  18. Crea una vista mostrando el número de pagos efectuados en cada forma de pago
#-------------------------------------------------------------------------------------------

