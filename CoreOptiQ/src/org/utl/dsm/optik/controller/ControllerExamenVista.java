
package org.utl.dsm.optik.controller;

import org.utl.dsm.optik.model.Examen_Vista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Cliente;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.GraduacionLentes;
import org.utl.dsm.optik.model.Persona;
import org.utl.dsm.optik.model.Usuario;

public class ControllerExamenVista {
    public int InsertarExamenVista(Examen_Vista examen_Vista) throws SQLException {

        //Paso 1: Preparar la sentencia sql
        String query = "{call insertarExamenVista(?,?,?,?,?)}";
        int idExamenVistaG = 0;

        //Paso 2: Conectar a sql
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //Paso 4: Asignar los valores para cada parametro
        cstmt.setInt(1, examen_Vista.getEmpleado().getIdEmpleado());
        cstmt.setString(2, examen_Vista.getClave());
        cstmt.setInt(3, examen_Vista.getCliente().getIdCliente());
        cstmt.setInt(4, examen_Vista.getGraduacion().getIdGraduacion());

        //Paso 5: Registrar paramtros de salida del procedure
        cstmt.registerOutParameter(5, Types.INTEGER);

        //Paso 6: Ejecutar la llamada al procedure
        cstmt.executeUpdate();

        //Paso 7: Recuperar los parametros de salida
        idExamenVistaG = cstmt.getInt(5);

        //Paaso 8: Insertar los valores en el objeto
        examen_Vista.setIdExamenVista(idExamenVistaG);

        //Paso 9: Cerrar objetos de conexicon 
        cstmt.close();
        conn.close();
        conexion.close();

        //Paso 10: Devolver el id generado
        return idExamenVistaG;
    }
    
    public void ActualizarExamenVista(Examen_Vista examen_Vista) throws SQLException {

        //Paso 1: Preparar la sentencia sql
        String query = "{CALL actualizarExamenVista(?,?,?,?,?)}";

        //Paso 2: Conectar a sql
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setString(1, examen_Vista.getClave());
        cstmt.setInt(2, examen_Vista.getEmpleado().getIdEmpleado());
        cstmt.setInt(3, examen_Vista.getCliente().getIdCliente());
        cstmt.setInt(4, examen_Vista.getGraduacion().getIdGraduacion());
        
        cstmt.setInt(5, examen_Vista.getIdExamenVista());

        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();

    }
    
    public void EliminarExamenVista(Examen_Vista examen_Vista) throws SQLException {

        //Paso 1: Preparar la sentencia sql
        String query = "{CALL eliminarExamenVista(?)}";

        //Paso 2: Conectar a sql
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, examen_Vista.getIdExamenVista());

        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();

    }
    
    public void RecuperarExamenVista(Examen_Vista examen_Vista) throws SQLException {

        //Paso 1: Preparar la sentencia sql
        String query = "{CALL recuperarExamenVista(?)}";

        //Paso 2: Conectar a sql
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, examen_Vista.getIdExamenVista());

        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();

    }
    
    public List<Examen_Vista> getAllExamenVista(String filtro) throws SQLException{
        String query = "SELECT * FROM vistaEV WHERE estatus =" + filtro + ";";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Examen_Vista> examenVistas = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Empleado e = new Empleado();
            Cliente c = new Cliente();
            Persona pe = new Persona();
            Usuario u = new Usuario();
            Persona pc = new Persona();
            GraduacionLentes g = new GraduacionLentes();
            Examen_Vista ev = new Examen_Vista();

            //Datos empleado
            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombre(rs.getString("nombreUsuario"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol"));
            e.setUsuario(u);

            pe.setIdPersona(rs.getInt("idPersonaEmpleado"));
            pe.setNombre(rs.getString("nombreEmpleado"));
            pe.setApellidoMaterno(rs.getString("apellidoMaternoEmpleado"));
            pe.setApellidoPaterno(rs.getString("apellidoPaternoEmpleado"));
            pe.setCalle(rs.getString("calleEmpleado"));
            pe.setCiudad(rs.getString("ciudadEmpleado"));
            pe.setColonia(rs.getString("coloniaEmpleado"));
            pe.setCp(rs.getString("cpEmpleado"));
            pe.setEmail(rs.getString("emailEmpleado"));
            pe.setEstado(rs.getString("estadoEmpleado"));
            pe.setFechaNacimiento(rs.getString("fechaNacimientoEmpleado"));
            pe.setGenero(rs.getString("generoEmpleado"));
            pe.setNumero(rs.getString("numeroEmpleado"));
            pe.setTelCasa(rs.getString("telcasaEmpleado"));
            pe.setTelMovil(rs.getString("telmovilEmpleado"));
            e.setPersona(pe);

            e.setIdEmpleado(rs.getInt("idEmpleado"));
            e.setNumeroUnico(rs.getString("numeroUnicoEmpleado"));
            ev.setEmpleado(e);
            
            //Datos Cliente
            pc.setIdPersona(rs.getInt("idPersonaCliente"));
            pc.setNombre(rs.getString("nombreCliente"));
            pc.setApellidoMaterno(rs.getString("apellidoMaternoCliente"));
            pc.setApellidoPaterno(rs.getString("apellidoPaternoCliente"));
            pc.setCalle(rs.getString("calleCliente"));
            pc.setCiudad(rs.getString("ciudadCliente"));
            pc.setColonia(rs.getString("coloniaCliente"));
            pc.setCp(rs.getString("cpCliente"));
            pc.setEmail(rs.getString("emailCliente"));
            pc.setEstado(rs.getString("estadoCliente"));
            pc.setFechaNacimiento(rs.getString("fechaNacimientoCliente"));
            pc.setGenero(rs.getString("generoCliente"));
            pc.setNumero(rs.getString("numeroCliente"));
            pc.setTelCasa(rs.getString("telcasaCliente"));
            pc.setTelMovil(rs.getString("telmovilCliente"));
            c.setPersona(pc);

            c.setIdCliente(rs.getInt("idCliente"));
            c.setNumeroUnico(rs.getString("numeroUnicoCliente"));
            ev.setCliente(c);
            
            //Datos Graduacion
            g.setIdGraduacion(rs.getInt("idGraduacion"));
            g.setEsferaod(rs.getDouble("esferaod"));
            g.setEsferaoi(rs.getDouble("esferaoi"));
            g.setCilindrood(rs.getInt("cilindrood"));
            g.setCilindrooi(rs.getInt("cilindrooi"));
            g.setEjeod(rs.getInt("ejeod"));
            g.setEjeoi(rs.getInt("ejeoi"));
            g.setDip(rs.getString("dip"));
            ev.setGraduacion(g);
            
            ev.setIdExamenVista(rs.getInt("idExamenVista"));
            ev.setClave(rs.getString("clave"));
            ev.setFecha(rs.getString("fecha"));
            ev.setEstatus(rs.getInt("estatus"));
            examenVistas.add(ev);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return examenVistas;
    }
    
    public List<Examen_Vista> getAllExamenVistaIna(String filtroIna) throws SQLException{
        String query = "SELECT * FROM vistaEVI WHERE estatus =" + filtroIna + ";";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Examen_Vista> examenVistas = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Empleado e = new Empleado();
            Cliente c = new Cliente();
            Persona pe = new Persona();
            Usuario u = new Usuario();
            Persona pc = new Persona();
            GraduacionLentes g = new GraduacionLentes();
            Examen_Vista ev = new Examen_Vista();

            //Datos empleado
            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombre(rs.getString("nombreUsuario"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol"));
            e.setUsuario(u);

            pe.setIdPersona(rs.getInt("idPersonaEmpleado"));
            pe.setNombre(rs.getString("nombreEmpleado"));
            pe.setApellidoMaterno(rs.getString("apellidoMaternoEmpleado"));
            pe.setApellidoPaterno(rs.getString("apellidoPaternoEmpleado"));
            pe.setCalle(rs.getString("calleEmpleado"));
            pe.setCiudad(rs.getString("ciudadEmpleado"));
            pe.setColonia(rs.getString("coloniaEmpleado"));
            pe.setCp(rs.getString("cpEmpleado"));
            pe.setEmail(rs.getString("emailEmpleado"));
            pe.setEstado(rs.getString("estadoEmpleado"));
            pe.setFechaNacimiento(rs.getString("fechaNacimientoEmpleado"));
            pe.setGenero(rs.getString("generoEmpleado"));
            pe.setNumero(rs.getString("numeroEmpleado"));
            pe.setTelCasa(rs.getString("telcasaEmpleado"));
            pe.setTelMovil(rs.getString("telmovilEmpleado"));
            e.setPersona(pe);

            e.setIdEmpleado(rs.getInt("idEmpleado"));
            e.setNumeroUnico(rs.getString("numeroUnicoEmpleado"));
            ev.setEmpleado(e);
            
            //Datos Cliente
            pc.setIdPersona(rs.getInt("idPersonaCliente"));
            pc.setNombre(rs.getString("nombreCliente"));
            pc.setApellidoMaterno(rs.getString("apellidoMaternoCliente"));
            pc.setApellidoPaterno(rs.getString("apellidoPaternoCliente"));
            pc.setCalle(rs.getString("calleCliente"));
            pc.setCiudad(rs.getString("ciudadCliente"));
            pc.setColonia(rs.getString("coloniaCliente"));
            pc.setCp(rs.getString("cpCliente"));
            pc.setEmail(rs.getString("emailCliente"));
            pc.setEstado(rs.getString("estadoCliente"));
            pc.setFechaNacimiento(rs.getString("fechaNacimientoCliente"));
            pc.setGenero(rs.getString("generoCliente"));
            pc.setNumero(rs.getString("numeroCliente"));
            pc.setTelCasa(rs.getString("telcasaCliente"));
            pc.setTelMovil(rs.getString("telmovilCliente"));
            c.setPersona(pc);

            c.setIdCliente(rs.getInt("idCliente"));
            c.setNumeroUnico(rs.getString("numeroUnicoCliente"));
            ev.setCliente(c);
            
            //Datos Graduacion
            g.setIdGraduacion(rs.getInt("idGraduacion"));
            g.setEsferaod(rs.getDouble("esferaod"));
            g.setEsferaoi(rs.getDouble("esferaoi"));
            g.setCilindrood(rs.getInt("cilindrood"));
            g.setCilindrooi(rs.getInt("cilindrooi"));
            g.setEjeod(rs.getInt("ejeod"));
            g.setEjeoi(rs.getInt("ejeoi"));
            g.setDip(rs.getString("dip"));
            ev.setGraduacion(g);
            
            ev.setIdExamenVista(rs.getInt("idExamenVista"));
            ev.setClave(rs.getString("clave"));
            ev.setFecha(rs.getString("fecha"));
            ev.setEstatus(rs.getInt("estatus"));
            examenVistas.add(ev);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return examenVistas;
    }

    public List<Empleado> getAllEmpleado(String filtro) throws SQLException {
        String query = "SELECT * FROM vista_empleados WHERE estatus =" + filtro + ";";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Empleado> empleados = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Empleado e = new Empleado();
            Persona p = new Persona();
            Usuario u = new Usuario();

            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombre(rs.getString("nombre"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol"));
            e.setUsuario(u);

            p.setIdPersona(rs.getInt("idPersona"));
            p.setApellidoMaterno(rs.getString("apellidoMaterno"));
            p.setApellidoPaterno(rs.getString("apellidoPaterno"));
            p.setCalle(rs.getString("calle"));
            p.setCiudad(rs.getString("ciudad"));
            p.setColonia(rs.getString("colonia"));
            p.setCp(rs.getString("cp"));
            p.setEmail(rs.getString("email"));
            p.setEstado(rs.getString("estado"));
            p.setFechaNacimiento(rs.getString("fechaNacimiento"));
            p.setGenero(rs.getString("genero"));
            p.setNombre(rs.getString("nombre"));
            p.setNumero(rs.getString("numero"));
            p.setTelCasa(rs.getString("telcasa"));
            p.setTelMovil(rs.getString("telmovil"));
            e.setPersona(p);

            e.setIdEmpleado(rs.getInt("idEmpleado"));
            e.setNumeroUnico(rs.getString("numeroUnico"));
            e.setEstatus(rs.getInt("estatus"));
            empleados.add(e);
        }

        rs.close();
        pstmt.close();
        conn.close();
        return empleados;
    }
    
    public List<Cliente> getAllCliente(String filtro) throws SQLException {
        String query = "SELECT * FROM vista_clientes WHERE estatus =" + filtro + ";";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Cliente> clientes = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Cliente c = new Cliente();
            Persona p = new Persona();

            p.setIdPersona(rs.getInt("idPersona"));
            p.setApellidoMaterno(rs.getString("apellidoMaterno"));
            p.setApellidoPaterno(rs.getString("apellidoPaterno"));
            p.setCalle(rs.getString("calle"));
            p.setCiudad(rs.getString("ciudad"));
            p.setColonia(rs.getString("colonia"));
            p.setCp(rs.getString("cp"));
            p.setEmail(rs.getString("email"));
            p.setEstado(rs.getString("estado"));
            p.setFechaNacimiento(rs.getString("fechaNacimiento"));
            p.setGenero(rs.getString("genero"));
            p.setNombre(rs.getString("nombre"));
            p.setNumero(rs.getString("numero"));
            p.setTelCasa(rs.getString("telcasa"));
            p.setTelMovil(rs.getString("telmovil"));
            c.setPersona(p);

            c.setIdCliente(rs.getInt("idCliente"));
            c.setNumeroUnico(rs.getString("numeroUnico"));
            c.setEstatus(rs.getInt("estatus"));
            clientes.add(c);
        }

        rs.close();
        pstmt.close();
        conn.close();
        return clientes;
    }
    
    public List<GraduacionLentes> getAllGraduacion(String filtro) throws SQLException {
        String query = "SELECT * FROM vistaGraduacion WHERE estatus="+ filtro +";";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<GraduacionLentes> graduaciones = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            GraduacionLentes g = new GraduacionLentes();
            
            g.setIdGraduacion(rs.getInt("idGraduacion"));
            g.setEsferaod(rs.getDouble("esferaod"));
            g.setEsferaoi(rs.getDouble("esferaoi"));
            g.setCilindrood(rs.getInt("cilindrood"));
            g.setCilindrooi(rs.getInt("cilindrooi"));
            g.setEjeod(rs.getInt("ejeod"));
            g.setEjeoi(rs.getInt("ejeoi"));
            g.setDip(rs.getString("dip"));
            g.setEstatus(rs.getInt("estatus"));

            graduaciones.add(g);
        }

        rs.close();
        pstmt.close();
        conn.close();
        return graduaciones;
    }
    
}
