
package org.utl.dsm.optik.controller;

import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.Persona;
import org.utl.dsm.optik.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author urieh
 */
public class ControllerPrueba {
    
    public static void main(String[] args) throws Exception {
        ProbarConexion();
    }
    
    
    public static void ProbarConexion(){
        ConexionMySQL objConect = new ConexionMySQL();
        Connection conn = objConect.open();
        System.out.println(conn.toString());
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("hay un error");
        }
    }
    public static void ProbarGetAll() throws Exception {
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados = getAll("1");
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado.toString());
        }
    }
    
    public static void ProbarInsert() throws Exception {
        Persona persona = new Persona();

        persona.setNombre("Uriel");
        persona.setApellidoPaterno("Hernandez");
        persona.setApellidoMaterno("Garcia");
        persona.setGenero("M");
        persona.setFechaNacimiento("1990-01-01");
        persona.setCalle("Calle 1");
        persona.setNumero("123");
        persona.setColonia("Colonia 1");
        persona.setCp("12345");
        persona.setCiudad("Ciudad 1");
        persona.setEstado("Estado 1");
        persona.setTelCasa("1234567890");
        persona.setTelMovil("1234567890");
        persona.setEmail("urieher");
        Usuario usuario = new Usuario();
        usuario.setNombre("urieher");
        usuario.setContrasenia("123456");
        usuario.setRol("E");
        Empleado empleado = new Empleado();
        empleado.setPersona(persona);
        empleado.setUsuario(usuario);

        //preparar la query para insertar Empleado
        EmpleadoController objEmpleado = new EmpleadoController();
        int idReturned = objEmpleado.insert(empleado);
        System.out.println(empleado.toString());
        System.out.println("idReturned: " + idReturned);
       


    }

    public static List<Empleado> getAll(String filtro) throws Exception {
        //query con filtro
           String query = "SELECT * FROM vista_empleados WHERE estatus = " + filtro+"";
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
        usuario.setRol(rs.getString("rol"));
        empleado.setPersona(persona);
        empleado.setUsuario(usuario);
        empleado.setIdEmpleado(rs.getInt("idEmpleado"));
        empleado.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
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

   
    }
    

