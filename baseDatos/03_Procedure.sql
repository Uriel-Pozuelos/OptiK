-- codigo unico
DELIMITER //
CREATE PROCEDURE generarCodigoUnicoEmpleado(
    IN v_apePaterno VARCHAR(32),				-- 1
    IN v_apeMaterno VARCHAR(32),				-- 2
    OUT v_numeroUnico VARCHAR(65)				-- 3
)
BEGIN
	DECLARE v_timestamp VARCHAR(32);
	SET v_numeroUnico = LEFT(v_apePaterno,2);
    IF length(v_apeMaterno) != 0 THEN
		SET v_numeroUnico = CONCAT(v_numeroUnico, LEFT(v_apeMaterno,1));
	ELSE 
		SET v_numeroUnico = CONCAT(v_numeroUnico, 'x');
	END IF;
    SET v_numeroUnico = upper(v_numeroUnico);
	SET v_timestamp = CAST(unix_timestamp() AS CHAR);
    SET v_numeroUnico = CONCAT(v_numeroUnico, v_timestamp);
    SET v_numeroUnico = md5(v_numeroUnico);
END //
DELIMITER ;

-- prodecimientos almacenados de insertar y actualizar empleado, usuario y cliente en uno solo
DELIMITER //
CREATE PROCEDURE insertarEmpleado(    /* Datos Personales */
                                    IN    var_nombre          VARCHAR(64),    --  1
                                    IN    var_apellidoPaterno VARCHAR(64),    --  2
                                    IN    var_apellidoMaterno VARCHAR(64),    --  3
                                    IN  var_genero          VARCHAR(2),     --  4
                                    IN  var_fechaNacimiento VARCHAR(11),    --  5
                                    IN    var_calle           VARCHAR(129),   --  6
                                    IN  var_numero          VARCHAR(20),    --  7
                                    IN  var_colonia         VARCHAR(40),    --  8
                                    IN  var_cp              VARCHAR(25),    --  9
                                    IN  var_ciudad          VARCHAR(40),    -- 10
                                    IN  var_estado          VARCHAR(40),    -- 11
                                    IN    var_telcasa         VARCHAR(20),    -- 12
                                    IN    var_telmovil        VARCHAR(20),    -- 13
                                    IN    var_email           VARCHAR(129),   -- 14
                                   
                                    /* Datos de Usuario */
                                    IN    var_nombreUsuario   VARCHAR(129),   -- 15
                                    IN    var_contrasenia     VARCHAR(129),   -- 16
                                    IN    var_rol             VARCHAR(25),    -- 17                                   
                                   
                                    /* Valores de Retorno */
                                    OUT    var_idPersona       INT,            -- 18
                                    OUT    var_idUsuario       INT,            -- 19
                                    OUT    var_idEmpleado      INT,            -- 20
                                    OUT    var_numeroUnico     VARCHAR(65),    -- 21
                                    OUT 	var_lastToken       VARCHAR(65)     -- 22
                )
BEGIN
    DECLARE v_fecha DATE;
	SET v_fecha = STR_TO_DATE('01/01/1901 00:00:00', '%d/%m/%Y %H:%i:%S');
 	SET var_lastToken = "token";
    
    INSERT INTO persona(nombre,apellidoPaterno,apellidoMaterno,genero,fechaNacimiento,calle,numero,colonia,cp,ciudad,estado,telcasa,telmovil,email)
    VALUES(var_nombre,var_apellidoPaterno,var_apellidoMaterno,var_genero,v_fecha,var_calle,var_numero,var_colonia,var_cp,var_ciudad,var_estado,var_telcasa,var_telmovil,var_email);
    SET var_idPersona = LAST_INSERT_ID();
    
    INSERT INTO usuario(nombre,contrasenia,rol,lastToken)
    VALUES(var_nombreUsuario,var_contrasenia,var_rol,var_lastToken);
    SET var_idUsuario = LAST_INSERT_ID();
    
    CALL generarCodigoUnicoEmpleado(var_apellidoPaterno,var_apellidoMaterno,var_numeroUnico);
    
    INSERT INTO empleado(idPersona,idUsuario,numeroUnico)
    VALUES(var_idPersona,var_idUsuario,var_numeroUnico);
    SET var_idEmpleado = LAST_INSERT_ID();
    
END //

DELIMITER ;

# crear vista de empleados
DROP VIEW IF EXISTS vista_empleados;
CREATE VIEW vista_empleados AS(
    SELECT  e.idEmpleado,u.idUsuario, p.idPersona,p.nombre, p.apellidoPaterno, p.apellidoMaterno, p.genero, p.fechaNacimiento, p.calle,p.numero,p.colonia ,p.cp, p.ciudad, p.estado, p.telcasa, p.telmovil, p.email,u.nombre nombreU, u.contrasenia, u.rol, e.numeroUnico, e.estatus
    FROM empleado e
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
);

select * from vista_empleados;

SELECT *
    FROM empleado e
    INNER JOIN persona p ON e.idPersona = p.idPersona
    INNER JOIN usuario u ON e.idUsuario = u.idUsuario
	WHERE e.estatus = 1;

# PROCEDURE para actualizar empleado
DELIMITER //
CREATE PROCEDURE actualizarEmpleado(    /* Datos Personales */
                                    IN    var_nombre          VARCHAR(64),    --  1
                                    IN    var_apellidoPaterno VARCHAR(64),    --  2
                                    IN    var_apellidoMaterno VARCHAR(64),    --  3
                                    IN  var_genero          VARCHAR(2),     --  4
                                    IN  var_fechaNacimiento VARCHAR(11),    --  5
                                    IN    var_calle           VARCHAR(129),   --  6
                                    IN  var_numero          VARCHAR(20),    --  7
                                    IN  var_colonia         VARCHAR(40),    --  8
                                    IN  var_cp              VARCHAR(25),    --  9
                                    IN  var_ciudad          VARCHAR(40),    -- 10
                                    IN  var_estado          VARCHAR(40),    -- 11
                                    IN    var_telcasa         VARCHAR(20),    -- 12
                                    IN    var_telmovil        VARCHAR(20),    -- 13
                                    IN    var_email           VARCHAR(129),   -- 14
                                   
                                    /* Datos de Usuario */
                                    IN    var_nombreUsuario   VARCHAR(129),   -- 15
                                    IN    var_contrasenia     VARCHAR(129),   -- 16
                                    IN    var_rol             VARCHAR(25),    -- 17                                   
                                   
                                    /* Valores de Retorno */
                                    in    var_idPersona       INT,            -- 18
                                    in    var_idUsuario       INT,            -- 19
                                    in    var_idEmpleado      INT,            -- 20
                                    in    var_numeroUnico     VARCHAR(65)   -- 21
                ) 
BEGIN
    DECLARE v_fecha DATE;
    SET v_fecha = STR_TO_DATE(var_fechaNacimiento, '%d/%m/%Y');
    
    UPDATE persona SET nombre = var_nombre, apellidoPaterno = var_apellidoPaterno, apellidoMaterno = var_apellidoMaterno, genero = var_genero, fechaNacimiento = v_fecha, calle = var_calle, numero = var_numero, colonia = var_colonia, cp = var_cp, ciudad = var_ciudad, estado = var_estado, telcasa = var_telcasa, telmovil = var_telmovil, email = var_email WHERE idPersona = var_idPersona;
    
    UPDATE usuario SET nombre = var_nombreUsuario, contrasenia = var_contrasenia, rol = var_rol WHERE idUsuario = var_idUsuario;
    
    UPDATE empleado SET numeroUnico = var_numeroUnico WHERE idEmpleado = var_idEmpleado;
    
END //
DELIMITER ;
select * from vista_empleados;
CALL actualizarEmpleado('Liz', 'Garnica', 'Negrete', 'F', '01/01/1901', -- Datos Personales
                      'santa maria', '23', 'leon', '210909', 'leon', 'guanajuato', '4771234567', '4771234567', 'pepe@gmail',
                      'lizbeth', '909090', 'Administrador',         -- Datos de Seguridad
                      44, 33, 17, '3d786852143f90ad370b52295b0b5c96');
CALL insertarEmpleado('Lizbeth', 'garnica', 'negrete', 'F', '01/01/1901', -- Datos Personales
                      '23', 'santa maria', 'leon', '210909', 'leon', 'guanajuato', '4771234567', '4771234567', 'pepe@gmail',
                      'lizbeth', '909090', 'Administrador',         -- Datos de Seguridad
                      @out1, @out2, @out3, @out4, @out5);
-- procedimiento para eliminar empleado actualiza el estatus a 0
DROP procedure IF EXISTS eliminarEmpleado;
DELIMITER //
CREATE PROCEDURE eliminarEmpleado(IN var_idEmpleado INT)
BEGIN
    UPDATE empleado SET estatus = 0 WHERE idEmpleado = var_idEmpleado;
END //
DELIMITER ;



CREATE TABLE producto(
    idProducto          INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    codigoBarras        VARCHAR(65) NOT NULL DEFAULT '',
    nombre              VARCHAR(255) NOT NULL,
    marca               VARCHAR(129) NOT NULL,
    precioCompra        DOUBLE NOT NULL DEFAULT 0.0,
    precioVenta         DOUBLE NOT NULL DEFAULT 0.0,
    existencias         INT NOT NULL DEFAULT 1,
    estatus             INT NOT NULL DEFAULT 1 -- 1: Activo; 0: Inactivo o Eliminado
);
CREATE TABLE lente_contacto(
    idLenteContacto     INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    idProducto          INT NOT NULL,
    keratometria        INT NOT NULL DEFAULT 0, -- Se mide en milimicras
    fotografia          LONGTEXT NOT NULL,
    CONSTRAINT fk_lentecontacto_producto FOREIGN KEY (idProducto) 
                REFERENCES producto(idProducto)
);
-- procedimiento de insertar lentes de contacto usando producto y lente de contacto
DROP procedure IF EXISTS insertarLenteContacto;
DELIMITER //
CREATE PROCEDURE insertarLenteContacto(	
                                        IN var_nombre VARCHAR(255) -- 2
                                        ,IN var_marca VARCHAR(129) -- 3
                                        ,IN var_precioCompra DOUBLE -- 4
                                        ,IN var_precioVenta DOUBLE -- 5
                                        ,IN var_existencias INT -- 6
                                        ,IN var_keratometria INT -- 7
                                        ,IN var_fotografia LONGTEXT -- 8
										,in var_tipo VARCHAR(129)
                                        ,OUT var_idProducto INT -- 9
                                        ,OUT var_idLenteContacto INT -- 10
                                        ,OUT var_codigoBarras VARCHAR(65) -- 1
                                        )
BEGIN
    INSERT INTO producto(nombre, marca, precioCompra, precioVenta, existencias) VALUES(var_nombre, var_marca, var_precioCompra, var_precioVenta, var_existencias);
    SET var_idProducto = LAST_INSERT_ID();
    SET var_codigoBarras = concat("OQ-",var_idProducto);
    UPDATE producto SET codigoBarras = var_codigoBarras WHERE idProducto = var_idProducto;
    INSERT INTO lente_contacto(idProducto, keratometria, fotografia,tipo) VALUES(var_idProducto, var_keratometria, var_fotografia, var_tipo);
    SET var_idLenteContacto = LAST_INSERT_ID();
END //
DELIMITER ;
call insertarLenteContacto('lentes de contacto', 'marca', 100.0, 200.0, 10, 100, 'fotografia', @out1, @out2);

-- procedure para actualizar lente de contacto usando producto y lente de contacto
DROP procedure IF EXISTS actualizarLenteContacto;
DELIMITER //
CREATE PROCEDURE actualizarLenteContacto(
                                        IN var_idProducto INT -- 1
                                        ,IN var_idLenteContacto INT -- 2
                                        ,IN var_nombre VARCHAR(255) -- 3
                                        ,IN var_marca VARCHAR(129) -- 4
                                        ,IN var_precioCompra DOUBLE -- 5
                                        ,IN var_precioVenta DOUBLE -- 6
                                        ,IN var_existencias INT -- 7
                                        ,IN var_keratometria INT -- 8
                                        ,in var_tipo VARCHAR(129)
                                        ,IN var_fotografia LONGTEXT -- 9
                                        )
BEGIN
    UPDATE producto SET nombre = var_nombre, marca = var_marca, precioCompra = var_precioCompra, precioVenta = var_precioVenta, existencias = var_existencias WHERE idProducto = var_idProducto;
    UPDATE lente_contacto SET keratometria = var_keratometria, fotografia = var_fotografia, tipo = var_tipo WHERE idLenteContacto = var_idLenteContacto;
    IF var_existencias = 0 THEN
        UPDATE producto SET estatus = 0 WHERE idProducto = var_idProducto;
    END IF;
END //
DELIMITER ;

-- procedure para activar lente de contacto actualiza el estatus a 1
DROP procedure IF EXISTS activarLenteContacto;
DELIMITER //
CREATE PROCEDURE activarLenteContacto(IN var_idProducto INT)
BEGIN
    UPDATE producto SET estatus = 1 WHERE idProducto = var_idProducto;
END //
DELIMITER ;

-- procedure para eliminar lente de contacto actualiza el estatus a 0
DROP procedure IF EXISTS eliminarLenteContacto;
DELIMITER //
CREATE PROCEDURE eliminarLenteContacto(IN var_idProducto INT)
BEGIN
    UPDATE producto SET estatus = 0 WHERE idProducto = var_idProducto;
END //
DELIMITER ;

# procedimiento para saber si un usuario y contraseña son correctos
DROP procedure IF EXISTS login;
DELIMITER //
CREATE PROCEDURE login(IN var_usuario VARCHAR(65), IN var_contrasena VARCHAR(65), OUT var_resultado INT)
BEGIN
    declare var_estatus INT;
    SELECT COUNT(*) INTO var_resultado FROM usuario WHERE nombre = var_usuario AND contrasenia = var_contrasena;
    -- saber si el usuario esta activo dentro de empleado
    IF var_resultado = 1 THEN
        SELECT estatus INTO var_estatus FROM empleado WHERE idUsuario = (SELECT idUsuario FROM usuario WHERE nombre = var_usuario AND contrasenia = var_contrasena);
        IF var_estatus = 0 THEN
            SET var_resultado = 0;
        END IF;
    END IF;
END //

DELIMITER ;

call login('Diedsgo', 'admin', @out1);
select @out1;
select * from vista_empleados;

-- procedimiento para insertar un armazon
DROP procedure IF EXISTS insertarArmazon;
DELIMITER //
CREATE PROCEDURE insertarArmazon(
                                IN var_nombre VARCHAR(255) -- 1
                                ,IN var_marca VARCHAR(129) -- 2
                                ,in var_modelo VARCHAR(129) -- 3
                                ,in var_color VARCHAR(65)  -- 4
                                ,in var_descripcion VARCHAR(255) -- 5
                                ,in var_foto LONGTEXT -- 6
                                ,in var_dimensiones VARCHAR(65) -- 7
                                ,in var_precioCompra DOUBLE -- 8
                                ,in var_precioVenta DOUBLE -- 9
                                ,in var_existencias INT -- 10
                                ,out var_idProducto INT -- 11
                                ,out var_idArmazon INT -- 12
                                ,out var_codigoBarras VARCHAR(65) -- 13
                                )
BEGIN
    INSERT INTO producto(nombre, marca, precioCompra, precioVenta, existencias) VALUES(var_nombre, var_marca, var_precioCompra, var_precioVenta, var_existencias);
    SET var_idProducto = LAST_INSERT_ID();
    SET var_codigoBarras = concat("OA-",var_idProducto);
    UPDATE producto SET codigoBarras = var_codigoBarras WHERE idProducto = var_idProducto;
    INSERT INTO armazon(idProducto, modelo, color, descripcion, foto, dimensiones) VALUES(var_idProducto, var_modelo, var_color, var_descripcion, var_foto, var_dimensiones);
    SET var_idArmazon = LAST_INSERT_ID();
END //
DELIMITER ;
drop PROCEDURE IF EXISTS insertarArmazon;
call insertarArmazon("Redonda","Square", "200", "300", "4", "Material de titanio", "Plateado", "34.4, 56.17","es ta bonito",".png", @out1, @out2, @out3);
DELIMITER //


CREATE TABLE accesorio(
    idAccesorio         INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    idProducto          INT NOT NULL,    
    CONSTRAINT fk_accesorio_producto FOREIGN KEY (idProducto) 
                REFERENCES producto(idProducto)
);
CREATE TABLE producto(
    idProducto          INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    codigoBarras        VARCHAR(65) NOT NULL DEFAULT '',
    nombre              VARCHAR(255) NOT NULL,
    marca               VARCHAR(129) NOT NULL,
    precioCompra        DOUBLE NOT NULL DEFAULT 0.0,
    precioVenta         DOUBLE NOT NULL DEFAULT 0.0,
    existencias         INT NOT NULL DEFAULT 1,
    estatus             INT NOT NULL DEFAULT 1 -- 1: Activo; 0: Inactivo o Eliminado
);

-- procedimiento para insertar un accesorio
DROP procedure IF EXISTS insertarAccesorio;
DELIMITER //
CREATE PROCEDURE insertarAccesorio(
                                IN var_nombre VARCHAR(255) -- 1
                                ,IN var_marca VARCHAR(129) -- 2
                                ,in var_precioCompra DOUBLE -- 5
                                ,in var_precioVenta DOUBLE -- 6
                                ,in var_existencias INT -- 7
                                ,out var_idProducto INT -- 8
                                ,out var_idAccesorio INT -- 9
                                ,out var_codigoBarras VARCHAR(65) -- 10
                                )
BEGIN
    INSERT INTO producto(nombre, marca, precioCompra, precioVenta, existencias) VALUES(var_nombre, var_marca, var_precioCompra, var_precioVenta, var_existencias);
    SET var_idProducto = LAST_INSERT_ID();
    SET var_codigoBarras = concat("OA-",var_idProducto);
    UPDATE producto SET codigoBarras = var_codigoBarras WHERE idProducto = var_idProducto;
    INSERT INTO accesorio(idProducto) VALUES(var_idProducto);
    SET var_idAccesorio = LAST_INSERT_ID();
END //
DELIMITER ;
 CALL insertarAccesorio("Redonda","Square", "34.4, 56.17","es ta bonito",".png", @out1, @out2, @out3);

 -- procedimiento para actualizar un accesorio

DROP procedure IF EXISTS actualizarAccesorio;
DELIMITER //
CREATE PROCEDURE actualizarAccesorio(
                                IN var_idProducto INT -- 2
                                ,IN var_nombre VARCHAR(255) -- 3
                                ,IN var_marca VARCHAR(129) -- 4
                                ,in var_precioCompra DOUBLE -- 5
                                ,in var_precioVenta DOUBLE -- 6
                                ,in var_existencias INT -- 7
                                )
BEGIN
    UPDATE producto SET nombre = var_nombre, marca = var_marca, precioCompra = var_precioCompra, precioVenta = var_precioVenta, existencias = var_existencias WHERE idProducto = var_idProducto;
    -- si la existencia es 0, se cambia el estatus a 0
    IF var_existencias = 0 THEN
        UPDATE producto SET estatus = 0 WHERE idProducto = var_idProducto;
    END IF;
END //
DELIMITER ;

-- procedimiento para eliminar un accesorio
DROP procedure IF EXISTS eliminarAccesorio;
DELIMITER //
CREATE PROCEDURE eliminarAccesorio(
                                IN var_idProducto INT -- 2
                                )
BEGIN
    UPDATE producto SET estatus = 0 WHERE idProducto = var_idProducto;
END //
DELIMITER ;

-- procedimiento para activar un accesorio

DROP procedure IF EXISTS activarAccesorio;
DELIMITER //
CREATE PROCEDURE activarAccesorio(
                                IN var_idProducto INT -- 2
                                )
BEGIN
    UPDATE producto SET estatus = 1 WHERE idProducto = var_idProducto;
END //
DELIMITER ;

-- vista para mostrar los accesorios
DROP VIEW IF EXISTS vistaAccesorio;
CREATE VIEW vistaAccesorio AS
SELECT p.idProducto, p.codigoBarras, p.nombre, p.marca, p.precioCompra, p.precioVenta, p.existencias, p.estatus, a.idAccesorio
FROM producto p
INNER JOIN accesorio a ON p.idProducto = a.idProducto;
