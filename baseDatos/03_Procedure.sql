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