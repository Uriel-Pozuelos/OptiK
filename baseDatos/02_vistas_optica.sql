use optiqalumnos;
select * from vista_accesorios where estatus =0;
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
SELECT * from vista_empleados WHERE estatus =1;
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
    SELECT  c.idCliente,p.idPersona, p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento,p.calle,p.numero,p.colonia ,p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, c.numeroUnico, estatus
    FROM cliente c
    INNER JOIN persona p ON c.idPersona = p.idPersona
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
  select idMaterial, nombre, precioCompra, precioVenta, estatus
  from material
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
  select idTratamiento, nombre, precioCompra, precioVenta,estatus from tratamiento
);
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
(select a.idAccesorio, p.idProducto, p.codigoBarras, p.nombre, p.marca, p.precioCompra, p.precioVenta, p.existencias, estatus
from producto p 
inner join accesorio a 
on p.idProducto = a.idProducto);
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
 SELECT * FROM vista_empleados WHERE estatus = 1;
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
	SELECT lc.idLenteContacto,estatus,tipo ,p.idProducto, lc.keratometria, lc.fotografia, p.codigoBarras, p.nombre, p.marca, p.precioCompra, p.precioVenta, p.existencias
    FROM lente_contacto lc
    INNER JOIN producto p
    ON p.idProducto = lc.idProducto
);
SELECT * FROM v_lentecontacto where estatus =1;
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



SELECT  DATE_FORMAT(NOW(), '%H:%i');

drop view vistaEV;
CREATE VIEW vistaEV AS(
	SELECT ev.idExamenVista, ev.clave, 
	e.idEmpleado, e.numeroUnico numeroUnicoEmpleado, u.idUsuario, u.nombre nombreUsuario, u.contrasenia, u.rol, pe.idPersona idPersonaEmpleado, pe.nombre nombreEmpleado, pe.apellidoPaterno apellidoPaternoEmpleado, pe.apellidoMaterno apellidoMaternoEmpleado, pe.genero generoEmpleado, pe.fechaNacimiento fechaNacimientoEmpleado, pe.calle calleEmpleado, pe.numero numeroEmpleado, pe.colonia coloniaEmpleado, pe.cp cpEmpleado, pe.ciudad ciudadEmpleado, pe.estado estadoEmpleado, pe.telcasa telcasaEmpleado, pe.telmovil telmovilEmpleado, pe.email emailEmpleado,
	c.idCliente, c.numeroUnico numeroUnicoCliente, pc.idPersona idPersonaCliente, pc.nombre nombreCliente, pc.apellidoPaterno apellidoPaternoCliente, pc.apellidoMaterno apellidoMaternoCliente, pc.genero generoCliente, pc.fechaNacimiento fechaNacimientoCliente, pc.calle calleCliente, pc.numero numeroCliente, pc.colonia coloniaCliente, pc.cp cpCliente, pe.ciudad ciudadCliente, pc.estado estadoCliente, pc.telcasa telcasaCliente, pc.telmovil telmovilCliente, pc.email emailCliente,
	g.idGraduacion, g.esferaod, g.esferaoi, g.cilindrood, g.cilindrooi, g.ejeoi, g.ejeod, g.dip,
	ev.fecha, ev.estatus
	FROM examen_vista ev
	INNER JOIN empleado e ON ev.idEmpleado = e.idEmpleado
	INNER JOIN cliente c ON ev.idCliente = c.idCliente
	INNER JOIN persona pe ON e.idPersona = pe.idPersona
	INNER JOIN usuario u ON e.idUsuario = u.idUsuario
	INNER JOIN persona pc ON c.idPersona = pc.idPersona
	INNER JOIN graduacion g ON ev.idGraduacion = g.idGraduacion
	WHERE ev.estatus = 1
);

select * from vistaEV;

CREATE VIEW vistaP AS(
	SELECT p.idProducto, p.codigoBarras, p.nombre, p.marca, p.precioCompra, p.precioVenta, p.existencias, p.estatus
    FROM producto p
    WHERE estatus = 1
);

drop view vistaC;
DESCRIBE compra;
alter table compra
add estatus int not null default 1;

CREATE VIEW vistaC AS(
	SELECT c.idCompra, e.idEmpleado, e.numeroUnico, u.idUsuario, u.nombre nombre_usuario, u.contrasenia, u.rol, p.idPersona, p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle, p.numero, p.colonia, p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, c.estatus
    FROM compra c
    INNER JOIN empleado e ON c.idEmpleado = e.idEmpleado
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
    WHERE c.estatus = 1
);

drop view vistaCI;
CREATE VIEW vistaCI AS(
	SELECT c.idCompra, e.idEmpleado, e.numeroUnico, u.idUsuario, u.nombre nombre_usuario, u.contrasenia, u.rol, p.idPersona, p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle, p.numero, p.colonia, p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, c.estatus
    FROM compra c
    INNER JOIN empleado e ON c.idEmpleado = e.idEmpleado
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
    WHERE c.estatus = 0
);

select * from vista_clientes;


select * from vistaCompra;

select * from vistacP;
drop view vistaCP;
CREATE VIEW vistaCP AS(
	SELECT cp.idCompra, e.idEmpleado, e.numeroUnico, u.idUsuario, u.nombre nombreUsuario, u.contrasenia, u.rol, p.idPersona, p.nombre nombrePersona, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle, p.numero, p.colonia, p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, pr.idProducto, pr.codigoBarras, pr.nombre, pr.marca, pr.precioCompra, pr.precioVenta, pr.existencias, cp.precioUnitario, cp.cantidad, c.estatus
    FROM compra_producto cp
    INNER JOIN compra c on c.idCompra = cp.idCompra
    INNER JOIN producto pr ON pr.idProducto = cp.idProducto
    INNER JOIN empleado e ON c.idEmpleado = e.idEmpleado
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
    ORDER BY idCompra ASC
);






-- PRUEBAS 
SELECT cp.idCompra, e.idEmpleado, e.numeroUnico, u.idUsuario, u.nombre nombreUsuario, u.contrasenia, u.rol, p.idPersona, p.nombre nombrePersona, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle, p.numero, p.colonia, p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, pr.idProducto, pr.codigoBarras, pr.nombre, pr.marca, pr.precioCompra, pr.precioVenta, pr.existencias, cp.precioUnitario, cp.cantidad, c.estatus
FROM compra_producto cp
INNER JOIN compra c on c.idCompra = cp.idCompra
INNER JOIN producto pr ON pr.idProducto = cp.idProducto
INNER JOIN empleado e ON c.idEmpleado = e.idEmpleado
INNER JOIN persona p ON e.idPersona = p.idPersona
INNER JOIN usuario u ON e.idUsuario = u.idUsuario
WHERE cp.idCompra = 8
ORDER BY idCompra ASC;

select * from vistaCP WHERE idCompra = 10;

select * from vistaCP;
 
SELECT cp.idCompra, c.idEmpleado, cp.idProducto, cp.precioUnitario, cp.cantidad, p.codigoBarras, p.nombre, p.marca, p.precioVenta, p.precioCompra
FROM compra_producto cp
INNER JOIN compra c ON c.idCompra = cp.idCompra
INNER JOIN empleado e ON e.idEmpleado = c.idEmpleado
INNER JOIN persona pe ON e.idPersona = pe.idPersona
INNER JOIN producto p ON p.idProducto = cp.idProducto
ORDER BY idCompra ASC
; 

SELECT cp.idCompra, e.idEmpleado, e.numeroUnico, u.idUsuario, u.nombre nombreUsuario, u.contrasenia, u.rol, p.idPersona, p.nombre nombrePersona, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle, p.numero, p.colonia, p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, pr.idProducto, pr.codigoBarras, pr.nombre nombreProducto, pr.marca, pr.precioCompra, pr.precioVenta, pr.existencias, cp.precioUnitario, cp.cantidad, c.estatus
    FROM compra_producto cp
    INNER JOIN compra c on c.idCompra = cp.idCompra
    INNER JOIN producto pr ON pr.idProducto = cp.idProducto
    INNER JOIN empleado e ON c.idEmpleado = e.idEmpleado
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
    -- WHERE c.estatus = 1
;


select * from producto;

SELECT c.idCompra, c.idEmpleado, p.nombre, p.apellidoPaterno, p.apellidoMaterno, c.estatus
FROM compra c
INNER JOIN empleado e ON e.idEmpleado = c.idEmpleado
INNER JOIN persona p ON e.idPersona = p.idPersona
WHERE c.estatus = 1
ORDER BY idCompra ASC
;

select * from vistaCompra;

select * from vista_empleados_activos;

drop view vistaCompraProducto;

drop view vistaCompra;
create view vistaCompra as(
SELECT c.idCompra, c.idEmpleado, p.nombre, p.apellidoPaterno, p.apellidoMaterno, c.estatus
FROM compra c
INNER JOIN empleado e ON e.idEmpleado = c.idEmpleado
INNER JOIN persona p ON e.idPersona = p.idPersona
WHERE c.estatus = 1
ORDER BY idCompra ASC
);

select * from empleado;
select * from compra;
select * from compra_producto;

select idCompra, idProducto, 
ROW_NUMBER() OVER (PARTITION BY idCompra, idProducto ORDER BY idCompra) AS row_num
from compra_producto
where idCompra = 7;

select * from producto where estatus = 1;
 
 
update compra
set estatus = 0
where idCompra = 8;

select row_number() over(partition by idCompra order by idProducto asc) AS productos, idCompra, idProducto, precioUnitario, cantidad
from compra_producto
where idCompra = 7
;

select row_number() over(partition by idCompra order by idProducto asc) AS productos
from compra_producto
where idCompra = 7
;

-- PONER DENTTRO DE UN LOOP CON UN IF ELSE, EÑ WHERE SERA UN CONTADOR
select idCompra, idProducto, precioUnitario, cantidad
from 
(
select row_number() over(partition by idCompra order by idProducto asc) AS productos, idCompra, idProducto, precioUnitario, cantidad
from compra_producto
where idCompra = 7
) sl
where productos = 1
;

-- ESTE DEFINIRA EL LA CANTIDAD DE LOOP
select row_number() over(partition by idCompra order by idProducto asc) AS productos
from compra_producto
where idCompra = 7
order by  productos desc limit 1
;

select cp.idCompra, cp.idProducto, cp.cantidad, p.existencias from compra_producto cp
inner join producto p on p.idProducto = cp.idProducto
where cp.idCompra = 7;

select *
							from 
							(	select row_number() over(partition by idCompra order by idProducto asc) AS productos, idCompra, idProducto, precioUnitario, cantidad
								from compra_producto
								-- where idCompra = 7
							) sl
								-- where productos = 1
							;
                            
select * from compra;


select cp.idCompra, cp.idProducto, cp.cantidad, p.existencias from compra_producto cp
inner join producto p on p.idProducto = cp.idProducto
where cp.idCompra = 7;


drop view vistaEVI;
CREATE VIEW vistaEVI AS(
	SELECT ev.idExamenVista, ev.clave, 
	e.idEmpleado, e.numeroUnico numeroUnicoEmpleado, u.idUsuario, u.nombre nombreUsuario, u.contrasenia, u.rol, pe.idPersona idPersonaEmpleado, pe.nombre nombreEmpleado, pe.apellidoPaterno apellidoPaternoEmpleado, pe.apellidoMaterno apellidoMaternoEmpleado, pe.genero generoEmpleado, pe.fechaNacimiento fechaNacimientoEmpleado, pe.calle calleEmpleado, pe.numero numeroEmpleado, pe.colonia coloniaEmpleado, pe.cp cpEmpleado, pe.ciudad ciudadEmpleado, pe.estado estadoEmpleado, pe.telcasa telcasaEmpleado, pe.telmovil telmovilEmpleado, pe.email emailEmpleado,
	c.idCliente, c.numeroUnico numeroUnicoCliente, pc.idPersona idPersonaCliente, pc.nombre nombreCliente, pc.apellidoPaterno apellidoPaternoCliente, pc.apellidoMaterno apellidoMaternoCliente, pc.genero generoCliente, pc.fechaNacimiento fechaNacimientoCliente, pc.calle calleCliente, pc.numero numeroCliente, pc.colonia coloniaCliente, pc.cp cpCliente, pe.ciudad ciudadCliente, pc.estado estadoCliente, pc.telcasa telcasaCliente, pc.telmovil telmovilCliente, pc.email emailCliente,
	g.idGraduacion, g.esferaod, g.esferaoi, g.cilindrood, g.cilindrooi, g.ejeoi, g.ejeod, g.dip,
	ev.fecha, ev.estatus
	FROM examen_vista ev
	INNER JOIN empleado e ON ev.idEmpleado = e.idEmpleado
	INNER JOIN cliente c ON ev.idCliente = c.idCliente
	INNER JOIN persona pe ON e.idPersona = pe.idPersona
	INNER JOIN usuario u ON e.idUsuario = u.idUsuario
	INNER JOIN persona pc ON c.idPersona = pc.idPersona
	INNER JOIN graduacion g ON ev.idGraduacion = g.idGraduacion
	WHERE ev.estatus = 0
);

select * from vistaEVI;


drop view vistaC;
CREATE VIEW vistaC AS(
	SELECT c.idCliente, p.idPersona, c.numeroUnico, p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle, p.numero, p.colonia, p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, c.estatus
    FROM cliente c   
	INNER JOIN persona p ON c.idPersona = p.idPersona
    WHERE c.estatus = 1
);

select * from vistaC;



alter table examen_vista
add estatus int default 1;
CREATE VIEW vistaGraduacion AS (
	SELECT idGraduacion, esferaod, esferaoi, cilindrood, cilindrooi, ejeoi, ejeod, dip, estatus
    from graduacion
    WHERE estatus = 1
);

drop view vistaCompra;
CREATE VIEW vistaCompra AS(
	SELECT c.idCompra, e.idEmpleado, e.numeroUnico, u.idUsuario, u.nombre nombre_usuario, u.contrasenia, u.rol, p.idPersona, p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle, p.numero, p.colonia, p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, c.estatus
    FROM compra c
    INNER JOIN empleado e ON c.idEmpleado = e.idEmpleado
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
    WHERE c.estatus = 1
);
use optiqalumnos;
SELECT * FROM vistaCompra WHERE estatus =1;
SELECT * FROM vistaCompra WHERE estatus =1;
select * from compra;
drop view vistaCompra;
CREATE VIEW vistaCompra AS(
	SELECT c.idCompra, e.idEmpleado, e.numeroUnico, u.idUsuario, u.nombre nombre_usuario, u.contrasenia, u.rol, p.idPersona, p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle, p.numero, p.colonia, p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, c.estatus
    FROM compra c
    INNER JOIN empleado e ON c.idEmpleado = e.idEmpleado
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
);

drop view vistaCompraI;
CREATE VIEW vistaCompraI AS(
	SELECT c.idCompra, e.idEmpleado, e.numeroUnico, u.idUsuario, u.nombre nombre_usuario, u.contrasenia, u.rol, p.idPersona, p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle, p.numero, p.colonia, p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email, c.estatus
    FROM compra c
    INNER JOIN empleado e ON c.idEmpleado = e.idEmpleado
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
    WHERE c.estatus = 0
);
use optiqalumnos;
select * from usuario;

select * from usuario WHERE lastToken = '2180712d3a5084c2fd50426bb41dc63aafda63b2fc200ad5851e807b62cb2424';
