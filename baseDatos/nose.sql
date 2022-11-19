drop DATABASE if EXISTS db_bus;
create database db_bus;
use db_bus;
create table conductor(
idConductor int primary key not null auto_increment,
nombre varchar(40),
ape_paterno varchar(40),
ape_materno varchar(40)
);
select * from conductor;

create table bitacora(
idBitacora int primary key not null auto_increment,
idConductor int not null,
fecha datetime,
placa varchar(20),
lastTicket int,
foreign key bitacora(idConductor)
references conductor(idConductor));

create view v_bitacora AS Select idBitacora, nombre, ape_paterno,ape_materno,fecha,
placa,lastTicket from bitacora b inner join conductor c on b.idConductor = c.idConductor;

select * from v_bitacora;
drop procedure bitacora;
DELIMITER //

create procedure bitacora(
							in v_idConductor int,
                            in v_placa varchar(20),
                            in v_numero int
)
begin
insert into bitacora(idConductor,fecha,placa,lastTicket) values(v_idConductor,now(),v_placa,v_numero);
end//
DELIMITER ;

call bitacora(1,'bhsah78',123);

select * from v_bitacora;
