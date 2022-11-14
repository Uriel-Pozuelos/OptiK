
package org.utl.dsm.optik.controller;

import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.model.Persona;
import org.utl.dsm.optik.model.Usuario;

/**
 *
 * @author urieh
 */
public class EmpleadoController {
    /**
     * @param empleado objeto de tipo Empleado
     * @return idEmpleado si se inserto correctamente
     */
    public int insert(Empleado empleado) throws Exception {

        //preparar la query para insertar
        String query = "{call insertarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        //conectarse a la base de datos
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        //preparar valores de retorno
        int idEmpleado = 0;
        int idUsuario = 0;
        int idPersona = 0;
        String numeroUnico = "";
        String lastToken = "";
        //preparar el statement
        //generar un objeto que permita ejecutar la query al procedimiento almacenado callable statement
        CallableStatement cstmt = conn.prepareCall(query);
        //asignar los valores a los parametros del procedimiento almacenado
        cstmt.setString(1, empleado.getPersona().getNombre());
        cstmt.setString(2, empleado.getPersona().getApellidoPaterno());
        cstmt.setString(3, empleado.getPersona().getApellidoMaterno());
        //genero
        cstmt.setString(4, empleado.getPersona().getGenero());
        //fecha de nacimiento
        cstmt.setString(5, empleado.getPersona().getFechaNacimiento());
        //calle
        cstmt.setString(6, empleado.getPersona().getCalle());
        //numero
        cstmt.setString(7, empleado.getPersona().getNumero());
        //colonia
        cstmt.setString(8, empleado.getPersona().getColonia());
        //codigo postal
        cstmt.setString(9, empleado.getPersona().getCp());
        //ciudad
        cstmt.setString(10, empleado.getPersona().getCiudad());
        //estado
        cstmt.setString(11, empleado.getPersona().getEstado());
        //telCasa
        cstmt.setString(12, empleado.getPersona().getTelCasa());
        //telCelular
        cstmt.setString(13, empleado.getPersona().getTelMovil());
        //email
        cstmt.setString(14, empleado.getPersona().getEmail());
        // nombre de usuario
        cstmt.setString(15, empleado.getUsuario().getNombre());
        //contraseña
        cstmt.setString(16, empleado.getUsuario().getContrasenia());
        //rol
        cstmt.setString(17, empleado.getUsuario().getRol());
        // registrar parametros de salida del procedimiento almacenado
        cstmt.registerOutParameter(18, Types.INTEGER);
        cstmt.registerOutParameter(19, Types.INTEGER);
        cstmt.registerOutParameter(20, Types.INTEGER);
        cstmt.registerOutParameter(21, Types.VARCHAR);
        cstmt.registerOutParameter(22, Types.VARCHAR);
        //ejecutar el procedimiento almacenado
        cstmt.executeUpdate();
        //obtener los valores de los parametros de salida
        idPersona = cstmt.getInt(18);
        idUsuario = cstmt.getInt(19);
        idEmpleado = cstmt.getInt(20);
        numeroUnico = cstmt.getString(21);
        lastToken = cstmt.getString(22);
        // asignar los valores de los parametros de salida al objeto empleado
        empleado.setIdEmpleado(idEmpleado);
        empleado.getPersona().setIdPersona(idPersona);
        empleado.getUsuario().setIdUsuario(idUsuario);
        empleado.setNumeroUnico(numeroUnico);
        empleado.getUsuario().setLastToken(lastToken);
        //cerrar la conexion
        cstmt.close();
        conn.close();
        conexion.close();
        //regresar el id del empleado generado
        return idEmpleado;
    }

    public List<Empleado> getAll(String filtro) throws Exception {
        //query con filtro
        String query = "SELECT * FROM vista_empleados WHERE estatus = " + filtro + "";


        //conectar a la base de datos
        ConexionMySQL objConect = new ConexionMySQL();
        Connection conn = objConect.open();
        //preparar el statement
        Statement stmt = conn.createStatement();
        //ejecutar la query
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        //recorrer el resultset
        List<Empleado> listaEmpleados = new ArrayList<>();

        while (rs.next()) {
            Empleado empleado = new Empleado();
            Persona persona = new Persona();
            Usuario usuario = new Usuario();
            persona.setIdPersona(rs.getInt("idPersona"));
            persona.setNombre(rs.getString("nombre"));
            persona.setApellidoPaterno(rs.getString("apellidoPaterno"));
            persona.setApellidoMaterno(rs.getString("apellidoMaterno"));
            persona.setGenero(rs.getString("genero"));
            persona.setFechaNacimiento(rs.getString("fechaNacimiento"));
            persona.setCalle(rs.getString("calle"));
            persona.setNumero(rs.getString("numero"));
            persona.setColonia(rs.getString("colonia"));
            persona.setCp(rs.getString("cp"));
            persona.setCiudad(rs.getString("ciudad"));
            persona.setEstado(rs.getString("estado"));
            persona.setTelCasa(rs.getString("telCasa"));
            persona.setTelMovil(rs.getString("telMovil"));
            persona.setEmail(rs.getString("email"));
            usuario.setNombre(rs.getString("nombreU"));
            usuario.setContrasenia(rs.getString("contrasenia"));
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setRol(rs.getString("rol"));
            empleado.setPersona(persona);
            empleado.setUsuario(usuario);
            empleado.setIdEmpleado(rs.getInt("idEmpleado"));
            empleado.setNumeroUnico(rs.getString("numeroUnico"));
            empleado.setEstatus(rs.getInt("estatus"));
            listaEmpleados.add(empleado);
        }
        //cerrar la conexion
        conn.close();
        rs.close();
        pstmt.close();
        return listaEmpleados;
    }

    //modificar empleado
    public String updateEmpleado(Empleado empleado) throws Exception {
        //query
        String query = "{call actualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        //conectar a la base de datos
        ConexionMySQL objConect = new ConexionMySQL();
        Connection conn = objConect.open();
        //preparar el statement
        CallableStatement cstmt = conn.prepareCall(query);
        //asignar los valores a los parametros del procedimiento almacenado
        //nombre
        cstmt.setString(1, empleado.getPersona().getNombre());
        //apellidoPaterno
        cstmt.setString(2, empleado.getPersona().getApellidoPaterno());
        //apellidoMaterno
        cstmt.setString(3, empleado.getPersona().getApellidoMaterno());
        //genero
        cstmt.setString(4, empleado.getPersona().getGenero());
        //fechaNacimiento
        cstmt.setString(5, empleado.getPersona().getFechaNacimiento());
        //calle
        cstmt.setString(6, empleado.getPersona().getCalle());
        //numero
        cstmt.setString(7, empleado.getPersona().getNumero());
        //colonia
        cstmt.setString(8, empleado.getPersona().getColonia());
        //codigo postal
        cstmt.setString(9, empleado.getPersona().getCp());
        //ciudad
        cstmt.setString(10, empleado.getPersona().getCiudad());
        //estado
        cstmt.setString(11, empleado.getPersona().getEstado());
        //telCasa
        cstmt.setString(12, empleado.getPersona().getTelCasa());
        //telCelular
        cstmt.setString(13, empleado.getPersona().getTelMovil());
        //email
        cstmt.setString(14, empleado.getPersona().getEmail());
        // nombre de usuario
        cstmt.setString(15, empleado.getUsuario().getNombre());
        //contraseña
        cstmt.setString(16, empleado.getUsuario().getContrasenia());
        //rol
        cstmt.setString(17, empleado.getUsuario().getRol());
        //idPersona
        cstmt.setInt(18, empleado.getPersona().getIdPersona());
        //idUsuario
        cstmt.setInt(19, empleado.getUsuario().getIdUsuario());
        //idEmpleado
        cstmt.setInt(20, empleado.getIdEmpleado());
        //numeroUnico
        cstmt.setString(21, empleado.getNumeroUnico());

        //ejeuctar el procedimiento almacenado
        cstmt.execute();
        //cerrar la conexion
        conn.close();
        cstmt.close();
        objConect.close();
        return "Empleado modificado";
    }

    public String eliminarEmpleado(int idEmpleado) throws Exception {
        //query
        String query = "{call eliminarEmpleado(?)}";
        //conectar a la base de datos
        ConexionMySQL objConect = new ConexionMySQL();
        Connection conn = objConect.open();
        //preparar el statement
        CallableStatement cstmt = conn.prepareCall(query);
        //asignar los valores a los parametros del procedimiento almacenado
        //idEmpleado
        cstmt.setInt(1, idEmpleado);
        //ejeuctar el procedimiento almacenado
        cstmt.execute();
        //cerrar la conexion
        conn.close();
        cstmt.close();
        objConect.close();
        return "Empleado eliminado";
    }
    
    public String activarEmpleado(int idEmpleado) throws Exception {
        //query
        String query = "{call activarEmpleado(?)}";
        //conectar a la base de datos
        ConexionMySQL objConect = new ConexionMySQL();
        Connection conn = objConect.open();
        //preparar el statement
        CallableStatement cstmt = conn.prepareCall(query);
        //asignar los valores a los parametros del procedimiento almacenado
        //idEmpleado
        cstmt.setInt(1, idEmpleado);
        //ejeuctar el procedimiento almacenado
        cstmt.execute();
        //cerrar la conexion
        conn.close();
        cstmt.close();
        objConect.close();
        return "Empleado eliminado";
    }
}
