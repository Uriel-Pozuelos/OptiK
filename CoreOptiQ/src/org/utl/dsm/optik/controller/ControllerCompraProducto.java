/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.controller;

import org.utl.dsm.optik.model.Compra;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Compra_Producto;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.Persona;
import org.utl.dsm.optik.model.Producto;
import org.utl.dsm.optik.model.Usuario;

/**
 *
 * @author urieh
 */
public class ControllerCompraProducto {
    
    public int InsertarCompra(Compra_Producto compra_Producto) throws SQLException{
        
        //Paso 1: Preparar la sentencia sql
        String query = "{call insertarCompraProducto(?,?,?,?)}";
        int idCompraG = 0;
        
        //Paso 2: Conectar a sql
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);
        
        //Paso 4: Asignar los valores para cada parametro
        cstmt.setInt(1, compra_Producto.getCompra().getEmpleado().getIdEmpleado());
        cstmt.setInt(2, compra_Producto.getProducto().getIdProducto());
        cstmt.setInt(3, compra_Producto.getCantidad());
        
        //Paso 5: Registrar paramtros de salida del procedure
        cstmt.registerOutParameter(4, Types.INTEGER);
        
        //Paso 6: Ejecutar la llamada al procedure
        cstmt.executeUpdate();
        
        //Paso 7: Recuperar los parametros de salida
        idCompraG = cstmt.getInt(4);
        
        //Paaso 8: Insertar los valores en el objeto
        compra_Producto.getCompra().setIdCompra(idCompraG);
        
        //Paso 9: Cerrar objetos de conexicon 
        cstmt.close();
        conn.close();
        conexion.close();
        
        //Paso 10: Devolver el id generado
        return idCompraG;
    }
    
    
    public void InsertarProductoCompra(Compra_Producto compra_Producto) throws SQLException{
        
        //Paso 1: Preparar la sentencia sql
        String query = "{CALL agregarProductoCompra(?,?)}";
        
        //Paso 2: Conectar a sql
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);
        
        //Paso 4: Asignar los valores para cada parametro
        cstmt.setInt(1, compra_Producto.getProducto().getIdProducto());
        cstmt.setInt(2, compra_Producto.getCantidad());
        
        //Paso 6: Ejecutar la llamada al procedure
        cstmt.execute();
        
        //Paso 9: Cerrar objetos de conexicon 
        cstmt.close();
        conn.close();
        conexion.close();
        
    }
    
    
    public List<Empleado> getAllEmpleado(String filtro) throws Exception {
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
    
    
    public List<Producto> getAllProducto(String filtro) throws SQLException {
        String query = "SELECT * FROM vistaP WHERE estatus =" + filtro + ";";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Producto> productos = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Producto p = new Producto();
            
            p.setIdProducto(rs.getInt("idProducto"));
            p.setCodigoBarras(rs.getString("codigoBarras"));
            p.setNombre(rs.getString("nombre"));
            p.setMarca(rs.getString("marca"));
            p.setPrecioCompra(rs.getDouble("precioCompra"));
            p.setPrecioVenta(rs.getDouble("precioVenta"));
            p.setExistencias(rs.getInt("existencias"));
            p.setEstatus(rs.getInt("estatus"));
            productos.add(p);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return productos;
    }
    
  
     public List<Compra> getAllCompra(String filtro) throws SQLException {
        String query = "SELECT * FROM vistaCompra WHERE estatus =" + filtro + ";";
         System.out.println(query);
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Compra> compras = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
         System.out.println("a");
        while (rs.next()) {
            System.out.println("b");
            Compra c = new Compra();
            Empleado e = new Empleado();
            Persona p = new Persona();
            Usuario u = new Usuario();
             
            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombre(rs.getString("nombre"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol"));
            e.setUsuario(u);
            
            System.out.println(rs.getString("rol"));
            u.setNombre(rs.getString("nombre_usuario"));
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
            c.setEmpleado(e);
            
            c.setIdCompra(rs.getInt("idCompra"));
            c.setEstatus(rs.getInt("estatus"));
           System.out.println(c.toString());
            compras.add(c);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return compras;
    }
    
    public List<Compra_Producto> getAllCompraProducto(String filtro) throws SQLException{
        String query = "SELECT * FROM vistaCP WHERE idCompra = " + filtro + ";";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Compra_Producto> comprasProductos = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Producto pr = new Producto();
            Compra c = new Compra();
            Empleado e = new Empleado();
            Persona p = new Persona();
            Usuario u = new Usuario();
            Compra_Producto cp = new Compra_Producto();
            
            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombre(rs.getString("nombreUsuario"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol"));
            e.setUsuario(u);

            p.setIdPersona(rs.getInt("idPersona"));
            p.setNombre(rs.getString("nombrePersona"));
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
            p.setNumero(rs.getString("numero"));
            p.setTelCasa(rs.getString("telcasa"));
            p.setTelMovil(rs.getString("telmovil"));
            e.setPersona(p);

            e.setIdEmpleado(rs.getInt("idEmpleado"));
            e.setNumeroUnico(rs.getString("numeroUnico"));
            e.setEstatus(rs.getInt("estatus"));
            c.setEmpleado(e);
            
            c.setIdCompra(rs.getInt("idCompra"));
            
            pr.setIdProducto(rs.getInt("idProducto"));
            pr.setCodigoBarras(rs.getString("codigoBarras"));
            pr.setNombre(rs.getString("nombre"));
            pr.setMarca(rs.getString("marca"));
            pr.setPrecioCompra(rs.getDouble("precioCompra"));
            pr.setPrecioVenta(rs.getDouble("precioVenta"));
            pr.setExistencias(rs.getInt("existencias"));
            pr.setEstatus(rs.getInt("estatus"));
            
            cp.setCompra(c);
            cp.setProducto(pr);
            cp.setPrecioUnitario(rs.getDouble("precioUnitario"));
            cp.setCantidad(rs.getInt("cantidad"));
            
            comprasProductos.add(cp);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return comprasProductos;
    }
    
    public void EliminarCompra(Compra compra) throws SQLException{
        String query = "{CALL cancelarCompra(?)}";

        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, compra.getIdCompra());

        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();
    }
    
    public List<Compra> getAllCompraInactivos(String filtroIna) throws SQLException {
        String query = "SELECT * FROM vistaCI WHERE estatus =" + filtroIna + ";";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Compra> comprasIna = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Compra c = new Compra();
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
            c.setEmpleado(e);

            c.setIdCompra(rs.getInt("idCompra"));
            c.setEstatus(rs.getInt("estatus"));
            comprasIna.add(c);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return comprasIna;
    }
    
    public void RecuperarCompra(Compra compra) throws SQLException{
        String query = "{CALL recuperarCompra(?)}";

        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setInt(1, compra.getIdCompra());

        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();
    }
    
}
