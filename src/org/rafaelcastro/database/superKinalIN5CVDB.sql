drop database if exists superKinalIN5CVDB;

create database if not exists superKinalIN5CVDB;

use superKinalIN5CVDB;

create table Compras(
	compraId int not null auto_increment,
    fechaCompra Date not null,
    totalCompra decimal (10,2),
    primary key PK_compraId(compraId)
);

create table CategoriaProductos(
	categoriaProductoId int not null auto_increment,
    nombreCategoria varchar(30)not null,
    descripcionCategoria varchar(100)not null,
	primary key PK_categoriaProductoId(categoriaProductoId)
);

create table Cargos(
	cargoId int not null auto_increment,
    nombreCargo Varchar(30) not null,
    descripcionCargo varchar(100)not null,
    primary key PK_cargoId(cargoId)
);

create table Clientes(
	clienteId int not null auto_increment,
    nombre varchar(30) not null,
    apellido varchar(30) not null,
    telefono varchar(15),
    direccion varchar(150) not null,
    nit varchar (15) not null,
    primary key PK_clienteId(clienteId)
);


create table Empleados(
	empleadoId int not null auto_increment,
	nombreEmpleado varchar(30) not null,
	apellidoEmpleado varchar(30) not null,
    sueldo decimal(10,2) not null,
    horaEntrada time not null,
    horaSalida time not null,
    cargoId int not null,
    encargado int,
    primary key PK_empleadoId (empleadoId),
	constraint FK_encargado foreign key Empleados(encargado)
	references Empleados(empleadoId),
    constraint FK_Empleados_Cargos foreign key Empleados(cargoId)
		references Cargos(cargoId)
);

create table Facturas(
    facturaId int not null auto_increment,
    fecha date not null,
    hora time not null,
	total decimal(10,2),
    clienteId int not null,
    empleadoId int not null,
    primary key PK_facturaId(facturaId),
    constraint FK_Facturas_Clientes foreign key Facturas(clienteId)
        references Clientes(clienteId),
    constraint FK_Facturas_Empleados foreign key Facturas(empleadoId)
        references Empleados(empleadoId)
);


create table Distribuidores(
    distribuidorId int not null auto_increment,
    nombreDistribuidor varchar(30) not null,
    direccionDistribuidor varchar(200) not null,
    nitDistribuidor varchar(15) not null,
    telefonoDistribuidor varchar(15) not null,
    web varchar(50),
    primary key PK_distribuidorId(distribuidorId)
);

create table Productos(
    productoId int not null auto_increment,
    nombreProducto varchar(50) not null,
    descripcionProductos varchar (100),
    cantidadStock int (11),
    precioVentaUnitario decimal(10,2) not null,
    precioVentaMayor decimal(10,2) not null,
	precioCompra decimal(10,2) not null,
    imagenProducto LONGBLOB,
    distribuidorId int not null,
    categoriaProductoId int not null,
    primary key PK_productoId(productoId),
    constraint FK_Productos_Distribuidores foreign key Productos(distribuidorId)
            references Distribuidores(distribuidorId),
	constraint FK_Productos_CategoriaProductos foreign key Productos(categoriaProductoId)
        references CategoriaProductos(categoriaProductoId)
);

create table DetalleFactura(
    detalleFacturaId int not null auto_increment,
    facturaId int not null,
    productoId int not null,
    primary key PK_detalleFacturaId(detalleFacturaId),
    constraint FK_DetalleFactura_Facturas foreign key DetalleFactura(facturaId)
        references Facturas(facturaId),
    constraint FK_DetalleFactura_Productos foreign key DetalleFactura(productoId)
        references Productos(productoId)
);



create table DetalleCompra(
    detalleCompraId int not null auto_increment,
    compraId int not null,
    productoId int not null,
    primary key PK_detalleCompraId(detalleCompraId),
    constraint FK_DetalleCompra_Compras foreign key DetalleCompra(compraId)
        references Compras(compraId),
    constraint FK_DetalleCompra_Productos foreign key DetalleCompra(productoId)
        references Productos(productoId)
);

create table Promociones(
	promocionId int not null auto_increment,
    precioPromocion decimal(10,2) not null,
	descripcionPromocion varchar(100),
    fechaInicio Date not null,
    fechaFinalizacion Date not null,
    productoId int not null,
    primary key PK_promocionId (promocionId),
    constraint FK_Promociones_Productos foreign key Promociones(productoId)
		references Productos(productoId)
);

create table TicketSoporte(
	ticketSoporteId int not null auto_increment,
    descripcionTicket varchar(250) not null,
    estatus varchar(30) not null,
	clienteId int not null,
	facturaId int not null,
    primary key PK_ticketSoporteId(ticketSoporteId),
    constraint FK_TicketSoporte_Clientes foreign key TicketSoporte(clienteId)
		references Clientes(clienteId),
	constraint FK_TicketSoporte_Facturas foreign key TicketSoporte(facturaId)
        references Facturas(facturaId)
);


INSERT INTO Compras(fechaCompra, totalCompra)VALUES
 ('2024-05-21', 100.00);
 
INSERT INTO CategoriaProductos(nombreCategoria, descripcionCategoria)VALUES
('Higiene', 'Productos de Higiene');

INSERT INTO Cargos(nombreCargo, descripcionCargo)VALUES
 ('Gerente', ' El jefe.');

insert into Clientes(nombre,apellido,telefono,direccion, nit) values
	('Benjamin','Samayoa','153414','Izabal', '41385113');
  
    
INSERT INTO Empleados(nombreEmpleado, apellidoEmpleado, sueldo, horaEntrada, horaSalida, cargoId, encargado)VALUES
 ('Licia', 'Castillo', 5000.00, '02:00:00', '10:00:00', 1, NULL);

INSERT INTO Facturas(fecha, hora, total, clienteId, empleadoId)VALUES
 ('2024-07-22', '10:00:00', 78.4, 1, 1);

INSERT INTO Distribuidores(nombreDistribuidor, direccionDistribuidor, nitDistribuidor, telefonoDistribuidor, web)VALUES
 ('Distribuidor La concha', 'La reforma', '37891273871', '31892739173', 'www.LaConcha.com');

INSERT INTO Productos(nombreProducto, descripcionProductos,cantidadStock, precioVentaUnitario, precioVentaMayor, precioCompra, distribuidorId, categoriaProductoId)VALUES 
('Producto', 'Descripción del Producto ',40, 70.00, 55.00, 40.00, 1, 1);

INSERT INTO DetalleFactura(facturaId, productoId)VALUES
 (1, 1);
 
INSERT INTO DetalleCompra(compraId, productoId)VALUES 
(1, 1);

INSERT INTO Promociones(precioPromocion, descripcionPromocion, fechaInicio, fechaFinalizacion, productoId)VALUES
 (10.00, 'Promoción de Invierno', '2024-01-11', '2024-01-12', 1);

INSERT INTO TicketSoporte(descripcionTicket, estatus, clienteId, facturaId)VALUES
 ('No Jala', 'Finalizado', 1, 1);

set global time_zone = '-6:00';