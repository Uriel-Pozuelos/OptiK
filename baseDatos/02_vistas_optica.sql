use optiqalumnos;
# crear vista de empleados
#vista 1 
DROP VIEW IF EXISTS vista_empleados;
CREATE VIEW vista_empleados AS(
    SELECT  e.idEmpleado, p.idPersona,u.idUsuario,p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle,p.numero,p.colonia ,p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email ,u.contrasenia,u.nombre nombreU ,u.rol, e.numeroUnico,e.estatus
    FROM empleado e
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
);
SELECT * from vista_empleados WHERE estatus = 1;
SELECT  e.idEmpleado, p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle,p.numero,p.colonia ,p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, u.contrasenia,u.nombre nombreUsuario ,u.rol, e.numeroUnico,e.estatus
    FROM empleado e
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
	WHERE e.estatus = 1;
#inactivos
DROP VIEW IF EXISTS vista_empleados_inactivos;
CREATE VIEW vista_empleados_inactivos AS(
    SELECT  e.idEmpleado, p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle,p.numero,p.colonia ,p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, u.contrasenia,u.nombre nombreUsuario ,u.rol, e.numeroUnico
    FROM empleado e
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
	WHERE e.estatus = 0
);
select * from vista_empleados;
select * from vista_empleados_inactivos;
update empleado set estatus = 0
where idEmpleado = 8;

# crear vista de clientes
#vista 2
DROP VIEW IF EXISTS vista_clientes;
CREATE VIEW vista_clientes AS(
    SELECT  c.idCliente, p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento,p.calle,p.numero,p.colonia ,p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, c.numeroUnico
    FROM cliente c
    INNER JOIN persona p ON c.idPersona = p.idPersona
  WHERE c.estatus = 1
);
select * from vista_clientes;
select * from cliente;
select * from persona;

#inactivos
DROP VIEW IF EXISTS vista_clientes_inactivos;
CREATE VIEW vista_clientes_inactivos AS(
    SELECT  c.idCliente, p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento,p.calle,p.numero,p.colonia ,p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, c.numeroUnico
    FROM cliente c
    INNER JOIN persona p ON c.idPersona = p.idPersona
  WHERE c.estatus = 0
);
select * from vista_clientes_inactivos;
SELECT * from producto;

#crear vista de materiales menos el estatus
#vista 3
DROP VIEW IF EXISTS vista_material;
CREATE VIEW vista_material AS(
  select idMaterial, nombre, precioCompra, precioVenta
  from material
  where estatus = 1
);
SELECT * from vista_material;
#inactivos
DROP VIEW IF EXISTS vista_material_inactivos;
CREATE VIEW vista_material_inactivos AS(
  select idMaterial, nombre, precioCompra, precioVenta
  from material
  where estatus = 0
);
SELECT * from vista_material_inactivos;

#vista 4
#crear vista de tratamiento menos el estatus
DROP VIEW IF EXISTS vista_tratamiento;
CREATE VIEW vista_tratamiento AS(
  select idTratamiento, nombre, precioCompra, precioVenta from tratamiento
  WHERE estatus = 1
);
select * from vista_tratamiento_inactivos;
#vista 5
#crear la vista de armazon uniendo las tablas de armazon y producto
DROP VIEW IF EXISTS vista_armazon;
CREATE VIEW vista_armazon AS(
  SELECT a.idArmazon,a.idProducto, a.modelo, a.color, a.dimensiones, a.descripcion, a.fotografia, p.codigoBarras, p.nombre, p.marca, p.precioVenta, p.precioCompra,p.existencias
  FROM armazon a
  INNER JOIN producto p 
  ON a.idProducto = p.idProducto
  WHERE p.estatus = 1
);
#inactivos
select * from vista_armazon;
select * from vista_armazon_inactivos;
select * from producto;
select * from armazon;
insert into producto values(15,'138938669','armazon transparente','army',120,200,0,0);
insert into armazon values(15,15,'M0P','transparente','12x12','es un lindo armazon de lentes','foto.jpg');

select * from producto;
DROP VIEW IF EXISTS vista_armazon_inactivos;
CREATE VIEW vista_armazon_inactivos AS(
  SELECT a.idArmazon, a.modelo, a.color, a.dimensiones, a.descripcion, a.fotografia, p.codigoBarras, p.nombre, p.marca, p.precioVenta, p.precioCompra,p.existencias
  FROM armazon a
  INNER JOIN producto p 
  ON a.idProducto = p.idProducto
  WHERE p.estatus = 0
);
select * from vista_armazon;
SELECT * from vista_armazon_inactivos;
#vista 6
drop view if exists vista_accesorios;
create view vista_accesorios as
(select a.idAccesorio, p.idProducto, p.codigoBarras, p.nombre, p.marca, p.precioCompra, p.precioVenta, p.existencias
from producto p 
inner join accesorio a 
on p.idProducto = a.idProducto
WHERE p.estatus = 1);
select * from vista_accesorios;
select * from vista_accesorios_inactivos;
select * from producto;
insert into producto values(20,'1030501676','limpiador gris','xio',150,170,0,0);
insert into accesorio values(20,20);



#inactivos
drop view if exists vista_accesorios_inactivos;
create view vista_accesorios_inactivos as
(select a.idAccesorio, p.idProducto, p.codigoBarras, p.nombre, p.marca, p.precioCompra, p.precioVenta, p.existencias
from producto p 
inner join accesorio a 
on p.idProducto = a.idProducto
 WHERE p.estatus = 0);
 select * from vista_accesorios_inactivos;
 #vista 7
 #activas
 drop view if exists vista_soluciones;
 create view vista_soluciones as(
 select s.idSolucion, s.idProducto, s.estatus, p.codigoBarras, p.nombre, p.marca, p.precioCompra, p.precioVenta, p.existencias
 from solucion s
 inner join producto p on s.idProducto = p.idProducto
 where s.estatus = 1);
 select * from vista_soluciones;
 select * from solucion;
 insert into producto values(30,'11340383','solucion 10','soluciones maria',50,70,7,0);
insert into solucion values(10,30,0);
 
 #inactivas
 drop view if exists vista_soluciones_inactivos;
 create view vista_soluciones_inactivos as(
 select s.idSolucion, s.idProducto, s.estatus, p.codigoBarras, p.nombre, p.marca, p.precioCompra, p.precioVenta, p.existencias
 from solucion s
 inner join producto p on s.idProducto = p.idProducto
 where s.estatus = 0);
 select * from vista_soluciones_inactivos;
 #8
 DROP VIEW IF EXISTS v_lenteContacto;
CREATE VIEW v_lenteContacto AS(
	SELECT lc.idLenteContacto, p.idProducto, lc.keratometria, lc.fotografia, p.codigoBarras, p.nombre, p.marca, p.precioCompra, p.precioVenta, p.existencias
    FROM lente_contacto lc
    INNER JOIN producto p
    ON p.idProducto = lc.idProducto
    WHERE p.estatus = 1
);
SELECT * FROM v_lenteContacto;
insert into producto values(42,'113403903','lente contacto morado','eyeSoul',550,770,9,0);
insert into lente_contacto values(12,42,60,'foto.jpg');

#inactivos
DROP VIEW IF EXISTS v_lenteContacto_inactivos;
CREATE VIEW v_lenteContacto_inactivos AS(
	SELECT lc.idLenteContacto, p.idProducto, lc.keratometria, lc.fotografia, p.codigoBarras, p.nombre, p.marca, p.precioCompra, p.precioVenta, p.existencias
    FROM lente_contacto lc
    INNER JOIN producto p
    ON p.idProducto = lc.idProducto
    WHERE p.estatus = 0
);

SELECT * FROM v_lenteContacto_inactivos;


