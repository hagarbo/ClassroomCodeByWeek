#------------------------------------------------------
#	BASE DE DATOS Galicia
#-------------------------------------------------------------------------------------------------------------------
#	DICCIONARIO ASOCIADO
#-------------------------------------------------------------------------------------------------------------------
# dígito 			  = [ 0 | 1 | 2 | 3 | 4 | 5 | 6  | 7 | 8 |9 ]													*dígitos del sistema numérico*
# vocalMinúscula 	  = [ a | á | e | é | i | í | o | ó | u | ú | ü ]												*vocales minúsculas, sin y con tilde, y con diéresis*
# vocalMayúscula	  = [ A | Á | E | É | I | Í | O | Ó | U | Ú | Ü ]												*vocales mayúsculas, sin y con tilde, y con diéresis*
# consonanteMinúscula = [ b | c | d | f | g | h | j | k | l | m | n | ñ | p | q | r | s | t | v | w | x | y | z ]	*consonantes minúsculas*
# consonanteMinúscula = [ B | C | D | F | G | H | J | K | L | M | N | Ñ | P | Q | R | S | T | V | W | X | Y | Z ]	*consonantes mayúsculas*
# espacio			  = ' '																							*separación entre palabras*
# separador			  = [ , | . | ; | - | ( | ) ]
# letraMinúscula = [ vocalMinúscula | consonanteMinúscula ]															*letras minúsculas como unión entre vocales y consonantes en minúscula*
# letraMayúscula = [ vocalMayúscula | consonanteMayúscula ]															*letras mayúsculas como unión entre vocales y consonantes en mayúscula*
# letra = [ letraMinúscula | letraMayúscula | espacio ]																*alfabeto completo en minúscula y en mayúsculas, y con espacio de separación*
# alfanumérico = [ letra | dígito ]																					*unión entre el total de letras más espacio y dígitos*
#------------------------------------------------------------------------------------------------------

drop database if exists jardineria_teis;
create database 		jardineria_teis;
use 					jardineria_teis;

#------------------------------------------------------
#	CREACIÓN DE LA TABLA Oficina
#------------------------------------------------------
#	idOficina			clave primaria y autoincrementable
#	CiudadOficina		cadena de  40 caracteres, no puede ser nulo
#	RegionOficina		cadena de  40 caracteres, no puede ser nulo
#   PaisOficina         cadena de  40 caracteres, no puede ser nulo
#   CPostalOficina      cadena de  10 caracteres, no puede ser nulo
#   TelefonoOficina     cadena de  20 caracteres, 
#   DireccionOficina1   cadena de  80 caracteres, no puede ser nulo
#   DireccionOficina2   cadena de  80 caracteres, 
#------------------------------------------------------
#	OFICINA 		    = {Oficina}													                        *Información de las Oficinas*
#	Oficina 		    = @idOficina + CiudadOficina + RegionOficina + PaisOficina 
#                       CPostalOficina + (TelefonoOficina) + 	DireccionOficina1 + (DireccionOficina2)		*Información de cada Oficina de la jardineria*
#	idOficina 	        = dígito														                    *Identificador de cada Oficina y clave primaria*
#	CiudadOficina       = 1{letra}40													                    *Nombre de la Ciudad donde esta situada la Oficina*
#	RegionOficina       = 1{letra}40													                    *Nombre de la Region donde esta situada la Oficina*
#	PaisOficina         = 1{letra}40													                    *Nombre del Pais donde esta situada la Oficina*
#	CPostalOficina      = 5{dígito}10													                    *Codigo Postal de la Oficina*
#	TelefonoOficina     = 9{alfanumérico}20													                *Telefono de la Oficina*
#	DireccionOficina1   = 1{alfanumérico}40													                *Direccion de la Oficina - Primera linea*
#	DireccionOficina2   = 1{alfanumérico}40													                *Direccion de la Oficina - Segunda linea*
#------------------------------------------------------

#------------------------------------------------------
#	CREACIÓN DE LA TABLA Empleado
#------------------------------------------------------
#	idEmpleado			clave primaria y autoincrementable
#	NombreEmpleado		cadena de  40 caracteres, no puede ser nulo
#	PrimerApellido		cadena de  40 caracteres, no puede ser nulo
#   SegundoApellido     cadena de  40 caracteres,
#   Extension           cadena de  10 caracteres, no puede ser nulo
#   Email               cadena de  40 caracteres, 
#   Puesto              cadena de  40 caracteres,
#   Jefe                digito, 
#------------------------------------------------------
#	EMPLEADO 		= {Empleado}													                    *Información del Empleado*
#	Empleado 		= @idEmpleado + NombreEmpleado + PrimerApellido + (SegundoApellido) 
#                     Extension + (Email) + (Puesto) + (Jefe)		                                    *Información de cada Empleado de la jardineria*
#	idEmpleado 	    = dígito														                    *Identificador de cada Empleado y clave primaria*
#	NombreEmpleado  = 1{letra}40													                    *Nombre del Empleado*
#	PrimerApellido  = 1{letra}40													                    *Primer Apellido del Empleado*
#	SegundoApellido = 1{letra}40													                    *Segundo Apellido del Empleado*
#	Extension       = 1{dígito}10													                    *Extension donde trabaja el Empleado*
#	Email           = 1{alfanumérico}40													                *Correo Electronico del Empleado*
#	Puesto          = 1{letra}40													                    *Puesto que ocupa el Empleado*
#	Jefe            = dígito													                        *Identificador del jefe del Empleado - es un id de Empleado*
#------------------------------------------------------

#------------------------------------------------------
#	CREACIÓN DE LA TABLA Gama
#------------------------------------------------------
#	idGama  			clave primaria y autoincrementable
#	NombreGama		    cadena de  40 caracteres, no puede ser nulo
#	DescTexto		    cadena de  200 caracteres, 
#   DescHtml            cadena de  500 caracteres, 
#   Imagen              cadena de  80 caracteres, no puede ser nulo
#------------------------------------------------------
#	GAMA 		  = {Gama}													                    *Información de las Gamas de productos*
#	Gama 		  = @idGama + NombreGama + (DescTexto) + (DescHtml) + Imagen                  	*Información de cada Gama de Producto de la jardineria*
#	idGama        = dígito														                *Identificador de cada Gama y clave primaria*
#	NombreGama    = 1{letra}40													                *Nombre de la Gama*
#	DescTexto     = 1{letra}200													                *Descripcion en formato texto de la gama*
#	DescHtml      = 1{letra}500													                *Descripcion en formato HTML de la gama*
#	Imagen        = 1{dígito}80													                *Enlace a la imagen asociada a la Gama*
#------------------------------------------------------

#------------------------------------------------------
#	CREACIÓN DE LA TABLA Producto
#------------------------------------------------------
#	idProducto			clave primaria y autoincrementable
#	NombreProducto		cadena de  40 caracteres, no puede ser nulo
#	Dimensiones 		cadena de  40 caracteres, 
#   Proveedor           cadena de  40 caracteres, 
#   DescProducto        cadena de  100 caracteres, 
#   Stock               digito, no puede ser nulo
#   Precio              digito, no puede ser nulo
#   PVP                 digito, no puede ser nulo
#------------------------------------------------------
#	PRODUCTO 		= {Producto}													                    *Información de los Productos*
#	Producto 		= @idProducto + NombreProducto + (Dimensiones) + (Proveedor) + (DescProducto)
#                     Stock + Precio + PVP                                                              *Información de cada Producto de la jardineria*
#	idProducto 	    = dígito														                    *Identificador de cada Producto y clave primaria*
#	NombreProducto  = 1{letra}40													                    *Nombre del Producto*
#	Dimensiones     = 1{letra}40													                    *Dimensiones del Producto*
#	Proveedor       = 1{letra}40													                    *Nombre del Proveedor del Producto*
#	DescProducto    = 1{dígito}100													                    *Descripcion en formato texto del Producto*
#	Stock           = dígito												                            *Cantidad disponible en Stock del Producto*
#	Precio          = dígito.digito													                    *Precio al que se compra el Producto al Proveedor*
#	PVP             = dígito.digito													                    *Precio de venta al publico*
#------------------------------------------------------

#------------------------------------------------------
#	CREACIÓN DE LA TABLA Cliente
#------------------------------------------------------
#	idCliente			clave primaria y autoincrementable
#	NombreCliente		cadena de  40 caracteres, no puede ser nulo
#	NombreContacto		cadena de  40 caracteres, no puede ser nulo
#   ApellidosContacto   cadena de  40 caracteres, 
#   TelefonoCliente     cadena de  20 caracteres, no puede ser nulo
#   FaxCliente          cadena de  20 caracteres, 
#   CiudadCliente       cadena de  40 caracteres, no puede ser nulo
#   RegionCliente       cadena de  40 caracteres, 
#   PaisCliente         cadena de  40 caracteres, no puede ser nulo
#   CpostalCliente      cadena de  10 caracteres, no puede ser nulo
#   Credito             digito , no puede ser nulo
#   DireccionCliente1   cadena de  80 caracteres, no puede ser nulo
#   DireccionCliente2   cadena de  80 caracteres, 
#------------------------------------------------------
#	CLIENTE 		    = {Cliente}													                        *Información de los Clientes*
#	Cliente 		    = @idCliente + NombreCliente + NombreContacto + (ApellidosContacto) 
#                       TelefonoCliente + (FaxCliente) + 	CiudadCliente + (RegionCliente)	
                        + PaisCliente + CpostalCliente + Credito + 	DireccionCliente1 + (DireccionCliente2) *Información de cada Cliente de la jardineria*
#	idCliente 	        = dígito														                    *Identificador de cada Cliente y clave primaria*
#	NombreCliente       = 1{letra}40													                    *Nombre del Cliente*
#	NombreContacto      = 1{letra}40													                    *Nombre de la persona de contacto del Cliente*
#	ApellidosContacto   = 1{letra}40													                    *Apellido de la persona de contacto del Cliente*
#	TelefonoCliente     = 9{dígito}20													                    *Telefono de contacto del Cliente*
#	FaxCliente          = 9{alfanumérico}20													                *Fax del Cliente*
#	CiudadCliente       = 1{alfanumérico}40													                *Ciudad donde reside el Cliente*
#	RegionCliente       = 1{alfanumérico}40													                *Region donde reside el Cliente*
#	PaisCliente         = 1{alfanumérico}40													                *Pais donde reside el Cliente*
#	CpostalCliente      = 5{alfanumérico}10													                *Codigo Postal*
#	Credito             = digito.digito													                    *Credito disponible para el Cliente*
#	DireccionCliente1   = 1{alfanumérico}80													                *Direccion del Cliente - linea 1*
#	DireccionCliente2   = 1{alfanumérico}80													                *Direccion del Cliente - linea 2*
#------------------------------------------------------

#------------------------------------------------------
#	CREACIÓN DE LA TABLA Pedido
#------------------------------------------------------
#	idPedido			clave primaria y autoincrementable
#	FechaPedido 		cadena de  40 caracteres, no puede ser nulo
#	FechaEsperada		cadena de  40 caracteres, no puede ser nulo
#   FechaEntrega        cadena de  40 caracteres, no puede ser nulo
#   Estado              cadena de  10 caracteres, no puede ser nulo
#   Comentario          cadena de  20 caracteres, 
#------------------------------------------------------
#	PEDIDO 		    = {Pedido}													                    *Información de las Oficinas*
#	Pedido 		    = @idPedido + FechaPedido + FechaEsperada + FechaEntrega 
#                     Estado + (Comentario)                                                         *Información de cada Oficina de la jardineria*
#	idPedido 	    = dígito														                *Identificador de cada Oficina y clave primaria*
#	FechaPedido     = 1{letra}40													                *Nombre de la Ciudad donde esta situada la Oficina*
#	FechaEsperada   = 1{letra}40													                *Nombre de la Region donde esta situada la Oficina*
#	FechaEntrega    = 1{letra}40													                *Nombre del Pais donde esta situada la Oficina*
#	Estado          = 1{dígito}10													                *Codigo Postal de la Oficina*
#	Comentario      = 1{alfanumérico}20													            *Telefono de la Oficina*
#------------------------------------------------------

#------------------------------------------------------
#	CREACIÓN DE LA TABLA DetallesPedido
#------------------------------------------------------
#	idDetalle			clave primaria y autoincrementable
#	Unidades    		cadena de  40 caracteres, no puede ser nulo
#	PrecioUnitario		cadena de  40 caracteres, no puede ser nulo
#   NumeroLinea         cadena de  40 caracteres, no puede ser nulo
#------------------------------------------------------
#	DETALLESPEDIDO 	= {DetallesPedido}													        *Información de las los Detalles de cada Pedido*
#	DetallesPedido 	= @idDetalle + Unidades + PrecioUnitario + NumeroLinea                      *Información de cada linea asociada a un pedido de la jardineria*
#	idDetalle 	    = dígito														            *Identificador de cada Detalle y clave primaria*
#	Unidades        = digito													                *Cantidad de unidades del Producto que se realizo en un pedido*
#	PrecioUnitario  = digito.digito													            *Precio por unidad del producto asociado*
#	NumeroLinea     = digito													                *Numero de linea de pedido*
#------------------------------------------------------

#------------------------------------------------------
#	CREACIÓN DE LA TABLA Pago
#------------------------------------------------------
#	idPago  			clave primaria
#	FormaPago   		cadena de  40 caracteres, no puede ser nulo
#	FechaPago	    	cadena de  10 caracteres, no puede ser nulo
#   TotalAbonado        digito, no puede ser nulo
#------------------------------------------------------
#	PAGO 		    = {Pago}													                *Información de la transaccion de Pago*
#	Pago 		    = @idPago + FormaPago + FechaPago + TotalAbonado                        	*Información de cada Pago abonado a la jardineria*
#	idPago 	        = dígito														            *Identificador de cada transaccion y clave primaria*
#	FormaPago       = 1{letra}40													            *Forma en la que se realiza el Pago*
#	FechaPago       = 1{letra}10													            *Fecha en la que se realiza la transaccion*
#	TotalAbonado    = digito.digito													            *Importe del Pago*
#------------------------------------------------------
